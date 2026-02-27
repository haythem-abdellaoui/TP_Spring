package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Services.IEquipeService;

@RestController
@AllArgsConstructor
public class EquipeController {
    
    private IEquipeService equipeService;

}
