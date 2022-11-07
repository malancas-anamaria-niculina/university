package utcn.tema1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import utcn.tema1.Entity.Location;
import utcn.tema1.Entity.Petri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcn.tema1.DTO.TransitionDto;
import utcn.tema1.Entity.Transition;
import utcn.tema1.Mapper.MapStructMapper;
import utcn.tema1.Repository.LocationRepository;
import utcn.tema1.Repository.TransitionRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransitionService {
    @Autowired
    private TransitionRepository transitionRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    public void addTransition(TransitionDto transitionDto) {
        Transition transition = mapstructMapper.transitionDtoToTransition(transitionDto);
        System.out.print(transition.getEntryLocationId());
        LocationService locationService = new LocationService();

        transitionRepository.save(transition);

        if (transition.getEntryLocationId() != null) {
            Optional<Location> entryLocation = locationRepository.findById(transition.getEntryLocationId());
            if (entryLocation != null) {
                Location location = entryLocation.get();
                location.setOutputTransitionId(transition.getId());
                locationRepository.save(location);
            }
        }
        if (transition.getOutputLocationId() != null) {
            Optional<Location> outputLocation = locationRepository.findById(transition.getOutputLocationId());
            if (outputLocation != null) {
                outputLocation.get().setEntryTransitionId(transition.getId());
                locationRepository.save(outputLocation.get());
            }
        }
    }

    public void executeTransition(String transitionName) {
        List<Transition> transitions = transitionRepository.findByTransitionName(transitionName);
        List<Location> entryLocations = new ArrayList<>();
        transitions.stream().filter(transition -> transition.getEntryLocationId() != null).collect(Collectors.toList())
                .forEach(transition -> entryLocations
                        .add(locationRepository.findById(transition.getEntryLocationId()).get()));
        List<Location> outputLocations = new ArrayList<>();
        transitions.stream().filter(transition -> transition.getOutputLocationId() != null).collect(Collectors.toList())
                .forEach(
                        transition -> outputLocations
                                .add(locationRepository.findById(transition.getOutputLocationId()).get()));
        for (Location entryLocation : entryLocations) {
            if (entryLocation.getNumberOfTokens() == 0) {
                return;
            }
            entryLocation.setNumberOfTokens(entryLocation.getNumberOfTokens() - 1);
        }
        for (Location outputLocation : outputLocations) {
            outputLocation.setNumberOfTokens(outputLocation.getNumberOfTokens() + 1);
            locationRepository.save(outputLocation);
        }
        for (Location entryLocation : entryLocations) {
            locationRepository.save(entryLocation);
        }
    }
}
