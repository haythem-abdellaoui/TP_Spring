package tn.esprit.arctic.championnat1.Service;

import tn.esprit.arctic.championnat1.Entities.Equipe;
import tn.esprit.arctic.championnat1.Repository.EquipeRepository;

public class EquipeService implements IEquipeService{
    EquipeRepository er;
    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return er.save(equipe);
    }
}
