package utcn.tema1.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LocationDto {
    @JsonProperty("locationId")
    private Integer locationId;

    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("numberOfTokens")
    private Integer numberOfTokens;
    @JsonProperty("type")
    private String type;
    @JsonProperty("petriId")
    private Integer petriId;
}
