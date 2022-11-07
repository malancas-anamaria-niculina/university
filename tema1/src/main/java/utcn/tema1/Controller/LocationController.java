package utcn.tema1.Controller;

import java.util.List;
import java.util.Map;

import utcn.tema1.Service.LocationService;
import utcn.tema1.DTO.LocationDto;
import utcn.tema1.Entity.Location;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/all")
    public List<Location> getAllLocations(@RequestParam(name = "id") Integer petriId) {
        return locationService.getLocationNames(petriId);
    }

    @GetMapping("/mark")
    public Map<String, Integer> getCurrentMark(@RequestHeader(name = "id") Integer petriId) {
        return locationService.getCurrentMark(petriId);
    }

    @PostMapping(value = "/", consumes = { "application/json" })
    public void addOrUpdateLocation(@RequestBody LocationDto location) {
        locationService.addOrUpdateLocation(location);
    }
}
