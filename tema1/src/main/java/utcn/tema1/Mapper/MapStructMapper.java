package utcn.tema1.Mapper;

import org.mapstruct.Mapper;

import utcn.tema1.DTO.LocationDto;
import utcn.tema1.DTO.PetriDto;
import utcn.tema1.DTO.TransitionDto;
import utcn.tema1.Entity.Location;
import utcn.tema1.Entity.Petri;
import utcn.tema1.Entity.Transition;;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Location locationDtoToLocation(LocationDto locationDto);

    Petri petriDtoToPetri(PetriDto petriDto);

    Transition transitionDtoToTransition(TransitionDto transitionDto);
}