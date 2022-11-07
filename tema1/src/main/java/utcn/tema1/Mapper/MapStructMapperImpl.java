package utcn.tema1.Mapper;

import org.springframework.stereotype.Component;

import utcn.tema1.DTO.LocationDto;
import utcn.tema1.DTO.PetriDto;
import utcn.tema1.DTO.TransitionDto;
import utcn.tema1.Entity.Location;
import utcn.tema1.Entity.Petri;
import utcn.tema1.Entity.Transition;
import utcn.tema1.Service.PetriService;

@Component
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public Location locationDtoToLocation(LocationDto locationDto) {
        if (locationDto == null) {
            return null;
        }

        Location location = new Location();

        location.setPetriId(locationDto.getPetriId());
        location.setEntryTransitionId(locationDto.getEntryTransitionId());
        location.setLocationName(locationDto.getLocationName());
        location.setNumberOfTokens(locationDto.getNumberOfTokens());
        location.setOutputTransitionId(location.getOutputTransitionId());

        return location;
    }

    @Override
    public Transition transitionDtoToTransition(TransitionDto transitionDto) {
        System.out.print("Transition dtoto transition");
        if (transitionDto == null) {
            return null;
        }

        Transition transition = new Transition();

        transition.setEntryLocationId(transitionDto.getEntryLocationId());
        transition.setOutputLocationId(transitionDto.getOutputLocationId());
        transition.setSecondsOfExecution(transitionDto.getSecondsOfExecution());
        transition.setTempStart(transitionDto.getTempStart());
        transition.setTempStop(transitionDto.getTempStop());
        transition.setTransitionName(transitionDto.getTransitionName());
        transition.setPetriId(transitionDto.getPetriId());
        
        return transition;
    }

    @Override
    public Petri petriDtoToPetri(PetriDto petriDto) {
        if (petriDto == null) {
            return null;
        }

        Petri petri = new Petri();
        petri.setName(petriDto.getName());
        return petri;
    }
}
