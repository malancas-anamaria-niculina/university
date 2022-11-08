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

}
