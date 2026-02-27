package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Entities.Equipe;
import tn.esprit.arctic.championnat1.Repository.EquipeRepository;

@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService{

    private EquipeRepository eq;
    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return eq.save(equipe);
}

}