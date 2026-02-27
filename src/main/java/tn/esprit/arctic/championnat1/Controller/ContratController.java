package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Services.IContratService;

@RestController
@AllArgsConstructor
public class ContratController {
    
    private IContratService contratService;
    


}
