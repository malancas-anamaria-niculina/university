package utcn.tema1.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LocationDto {
    @JsonProperty("petriId")
    private Integer petriId;

    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("numberOfTokens")
    private Integer numberOfTokens;
    @JsonProperty("entryTransitionId")
    private Integer entryTransitionId;
    @JsonProperty("outputTransitionId")
    private Integer outputTransitionId;
}
