package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Entities.Equipe;
import tn.esprit.arctic.championnat1.Services.IEquipeService;

@RestController
@AllArgsConstructor
@RequestMapping("/equipes")
public class EquipeController {
    
    private IEquipeService equipeService;
    @PostMapping("/ajouter_equipe")
    public void ajouterEquipe(@RequestBody Equipe equipe) {
        equipeService.ajouterEquipe(equipe);
    }

}
