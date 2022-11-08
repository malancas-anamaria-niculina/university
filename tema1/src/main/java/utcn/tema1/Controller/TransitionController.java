package utcn.tema1.Controller;

import utcn.tema1.DTO.TransitionDto;
import utcn.tema1.Service.TransitionService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/api/transition")
public class TransitionController {
    @Autowired
    private TransitionService transitionService;

    /*@PostMapping(value = "/", consumes = { "application/json" })
    public void addTransition(@RequestBody TransitionDto transitionDto) {
        transitionService.addTransition(transitionDto);
    }

    @PostMapping(value = "/execute/")
    public void executeTransition(@RequestHeader(name = "transitionName") String transitionName) {
        transitionService.executeTransition(transitionName);
    }*/
}
