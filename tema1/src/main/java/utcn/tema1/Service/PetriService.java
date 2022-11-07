package utcn.tema1.Service;

import utcn.tema1.DTO.PetriDto;
import utcn.tema1.Entity.Petri;
import utcn.tema1.Mapper.MapStructMapper;
import utcn.tema1.Repository.PetriRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetriService {
    @Autowired
    private PetriRepository petriRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    public void addPetriNet(PetriDto petri) {
        Petri petriNet = mapstructMapper.petriDtoToPetri(petri);
        petriRepository.save(petriNet);
    }

    public String getNameById(Integer id) {
        Optional<Petri> petri = petriRepository.findById(id);
        return petri.get().getName();
    }

    public Petri getPetriNetById(Integer id) {
        Optional<Petri> petri = petriRepository.findById(id);
        System.out.println(petri);
        return petri.get();
    }
}
