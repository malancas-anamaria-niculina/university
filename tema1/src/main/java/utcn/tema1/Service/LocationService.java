package utcn.tema1.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utcn.tema1.DTO.LocationDto;
import utcn.tema1.Entity.Location;
import utcn.tema1.Mapper.MapStructMapper;
import utcn.tema1.Repository.LocationRepository;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    public List<Location> getLocationNames(Integer petriId) {
        /*
         * List<Location> locations = locationRepository.findAll().stream()
         * .filter(location -> location.getPetriNetById(petriId).getPetriId() ==
         * petriId).collect(Collectors.toList());
         */
        List<Location> locations = null;
        return locations;
    }

    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }

    public void addOrUpdateLocation(LocationDto locationDto) {
        Location location = mapstructMapper.locationDtoToLocation(locationDto);
        locationRepository.save(location);
    }

    public Map<String, Integer> getCurrentMark(Integer petriId) {
        List<Location> locations = getLocationNames(petriId);
        Collections.sort(locations, (o1, o2) -> (o1.getLocationName().compareTo(o2.getLocationName())));
        Map<String, Integer> mark = new HashMap<String, Integer>();
        locations.forEach(location -> mark.put(location.getLocationName(), location.getNumberOfTokens()));
        return mark;
    }
}
