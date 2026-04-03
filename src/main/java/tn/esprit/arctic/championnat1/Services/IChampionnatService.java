package tn.esprit.arctic.championnat1.Services;

import tn.esprit.arctic.championnat1.Entities.Championnat;
import tn.esprit.arctic.championnat1.Entities.DetailChampionnat;

public interface IChampionnatService {

    Championnat addChampionnatAndAssociatedCourses(Championnat championnat);

    DetailChampionnat ajouterEtaffecterDetailChampionnatAChampionnat(DetailChampionnat detailChampionnat, Long idChampionnat);

}
