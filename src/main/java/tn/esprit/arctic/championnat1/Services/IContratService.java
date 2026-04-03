package tn.esprit.arctic.championnat1.Services;

import tn.esprit.arctic.championnat1.Entities.Contrat;

public interface IContratService {

    Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, Long idEquipe, Long idSponsor);

    String affecterCourseAChampionnat(Long idCourse, Long idChampionnat);

}
