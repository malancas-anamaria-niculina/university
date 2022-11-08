package utcn.tema1.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransitionDto {
    @JsonProperty("transitionId")
    private Integer transitionId;
    @JsonProperty("petriId")
    private Integer petriId;

    @JsonProperty("transitionName")
    private String transitionName;
    @JsonProperty("tempStart")
    private Integer tempStart;
    @JsonProperty("tempStop")
    private Integer tempStop;
    @JsonProperty("secondsOfExecution")
    private Integer secondsOfExecution;
}
