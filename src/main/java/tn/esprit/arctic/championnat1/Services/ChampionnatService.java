package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Entities.Championnat;
import tn.esprit.arctic.championnat1.Entities.DetailChampionnat;
import tn.esprit.arctic.championnat1.Repository.ChampionnatRepository;
import tn.esprit.arctic.championnat1.Repository.DetailChampionnatRepository;

@Service
@AllArgsConstructor
public class ChampionnatService implements IChampionnatService {

    private final DetailChampionnatRepository detailChampionnatRepository;
    private ChampionnatRepository championnatRepository;

    @Override
    public Championnat addChampionnatAndAssociatedCourses (Championnat championnat) {
        Championnat savedChampionnat = championnatRepository.save(championnat);
        return championnatRepository.save(savedChampionnat);
    }

    @Override
    public DetailChampionnat ajouterEtaffecterDetailChampionnatAChampionnat(DetailChampionnat detailChampionnat, Long idChampionnat) {
        Championnat championnat = championnatRepository.findById(idChampionnat).get();
        DetailChampionnat savedDetailChampionnat = detailChampionnatRepository.save(detailChampionnat);
        championnat.setDetailChampionnat(savedDetailChampionnat);
        championnatRepository.save(championnat);
        return savedDetailChampionnat;
    }


}
