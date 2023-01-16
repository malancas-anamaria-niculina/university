package net.agten.heatersimulator.domain.algorithm;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class FUZZY implements ControllerAlgorithm{
    /**
     * The maximum result returned by the PID algorithm.
     */
    public final static int MAX_RESULT = 255;
    /**
     * The initial target ADC value.
     */
    public final static int INITIAL_TARGET_ADC = 830;
    private final int pGain;
    private final int iGain;
    private final int dGain;
    private final int outputDivisor;

    /**
     * The target ADC value.
     */
    private int targetAdc;

    /**
     * The current integral state.
     */
    private int iState = 0;
    /**
     * The last seen ADC value.
     */
    private int lastAdc = 1024;

    public FUZZY(int pGain, int iGain, int dGain, int outputDivisor) {
        System.out.println("GAINS: " + pGain + ", "+ iGain+", "+dGain+", "+outputDivisor);
        this.pGain = pGain;
        this.iGain = iGain;
        this.dGain = dGain;
        this.outputDivisor = outputDivisor;
        this.targetAdc = INITIAL_TARGET_ADC;
        System.out.println("initial target: " + targetAdc);
    }

    /**
     * Calculate the output value of this PID algorithm, based on a given 10-bit
     * ADC value.
     *
     * @param curAdc	a 10-bit ADC value representing the current reading
     * @return			a value between 0 and MAX_RESULT representing the
     * 					relative amount of power to apply in order to reach the
     * 					target ADC value
     */
    public short nextValue(short curAdc) {
        String filename = "D:\\Projects\\teme-ssatr-iaisc-icaf-2022-malancas-anamaria-niculina\\tema4\\src\\net\\agten\\heatersimulator\\temp-control.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }
        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);
        int error = this.targetAdc - curAdc;
        int adcdiff = lastAdc - curAdc;

        // Set inputs
        fb.setVariable("error", error);
        fb.setVariable("adcdiff", adcdiff);

        fb.evaluate();

        fb.getVariable("pGain").defuzzify();
        fb.getVariable("dGain").defuzzify();
        fb.getVariable("iGain").defuzzify();

        double fuzzyP = fb.getVariable("pGain").getValue();
        double fuzzyD = fb.getVariable("dGain").getValue();
        double fuzzyI = fb.getVariable("iGain").getValue();


        System.out.println("P,D,I FUZZY: " + fuzzyP + ", " + fuzzyD + ", " + fuzzyI);


        // Calculate the proportional term. This term uses information from the
        // now.
        int pTerm = (int)fuzzyP * error;

        // Calculate the differential term. This term uses the difference between
        // the current ADC value and the last ADC value to determine the speed
        // by which the ADC value is changing.
        int dTerm = (int)fuzzyD * (lastAdc - curAdc);
        this.lastAdc = curAdc;

        int result = (pTerm + dTerm)/outputDivisor;
        int iTerm = 0;
        // Only calculate the integral term if the heater is in the controllable
        // area.
        if (result < MAX_RESULT) {
            // iState keeps track of the accumulated error.
            this.iState += error;

            // Calculate the integral term. This term uses information from the past.
            iTerm = iGain * iState;
        }

        // Calculate the sum of each term, divided by the output divisor
        result += iTerm/outputDivisor;
        // Cap the result to [0,MAX_RESULT]
        result = Math.max(Math.min(result,MAX_RESULT), 0);

        return (short)result;
    }

    /**
     * Sets the target ADC value.
     *
     * @param targetAdc	the 10-bit target ADC value
     */
    public void setTargetAdc(short targetAdc) {
        this.targetAdc = targetAdc;
    }
}
