package utcn.tema1.Controller;

import org.springframework.web.bind.annotation.RestController;

import utcn.tema1.DTO.PetriDto;
import utcn.tema1.Entity.Petri;
import utcn.tema1.Service.PetriService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/api/petri")
public class PetriController {
    @Autowired
    private PetriService petriService;

    @PostMapping(value = "/", consumes = { "application/json" })
    public void savePetriNet(@RequestBody PetriDto petri) {
        petriService.addPetriNet(petri);
    }

    @GetMapping("/petri_name")
    public String getPetriNameById(@RequestHeader(name = "id") Integer id) {
        return petriService.getNameById(id);
    }

    @GetMapping("/")
    public Petri getPetriById(@RequestHeader(name = "id") Integer id) {
        return petriService.getPetriNetById(id);
    }
}
