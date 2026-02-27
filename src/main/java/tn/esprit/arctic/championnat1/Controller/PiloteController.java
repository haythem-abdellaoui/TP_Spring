package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Entities.Pilote;
import tn.esprit.arctic.championnat1.Services.IPiloteService;

@RestController
@AllArgsConstructor
@RequestMapping("/pilotes")
public class PiloteController {
    
    private IPiloteService piloteService;

    @PostMapping("/ajouter_pilote")
    public void ajouterPilote(@RequestBody Pilote pilote) {
        piloteService.addPilote(pilote);
    }


}
