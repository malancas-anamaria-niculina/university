package utcn.tema1.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PetriDto {
    @JsonProperty("name")
    private String name;
}
