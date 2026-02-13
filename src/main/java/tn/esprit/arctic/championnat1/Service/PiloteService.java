package tn.esprit.arctic.championnat1.Service;

import tn.esprit.arctic.championnat1.Entities.Pilote;
import tn.esprit.arctic.championnat1.Repository.PiloteRepository;

public class PiloteService implements IPiloteService {
    PiloteRepository pr;

    @Override
    public String addPilote(Pilote p) {
        pr.save(p);
        return "Pilote added";
    }
}
