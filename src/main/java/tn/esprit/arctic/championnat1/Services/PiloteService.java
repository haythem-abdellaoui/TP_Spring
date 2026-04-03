package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Entities.Equipe;
import tn.esprit.arctic.championnat1.Entities.Pilote;
import tn.esprit.arctic.championnat1.Repository.EquipeRepository;
import tn.esprit.arctic.championnat1.Repository.PiloteRepository;

@Service
@AllArgsConstructor
public class PiloteService implements IPiloteService{
    
    private PiloteRepository pil;
    private EquipeRepository eq;


    @Override
    public String addPilote(Pilote p) {
        pil.save(p);
        return "Pilote ajouté avec succès";
    }

    @Override
    public Pilote affecterPiloteAEquipe(Long idPilote, Long idEquipe) {
        Pilote pilote = pil.findById(idPilote).get();
        Equipe equipe = eq.findById(idEquipe).get();
        return pilote;
    }

    
}
