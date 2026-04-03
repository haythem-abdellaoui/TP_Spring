package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Entities.*;
import tn.esprit.arctic.championnat1.Repository.ChampionnatRepository;
import tn.esprit.arctic.championnat1.Repository.ContratRepository;
import tn.esprit.arctic.championnat1.Repository.CourseRepository;
import tn.esprit.arctic.championnat1.Repository.EquipeRepository;
import tn.esprit.arctic.championnat1.Repository.SponsorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {
    
    private ContratRepository contratRepository;
    private EquipeRepository equipeRepository;
    private SponsorRepository sponsorRepository;
    private CourseRepository courseRepository;
    private ChampionnatRepository championnatRepository;

    @Override
    public Contrat ajoutContratEtAffecterASponsorEtEquipe(Contrat contrat, Long idEquipe, Long idSponsor){
        Sponsor sponsor = sponsorRepository.findById(idSponsor).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        contrat.setSponsor(sponsor);
        contrat.setEquipe(equipe);
        return contratRepository.save(contrat);

    }

    @Override
    public String affecterCourseAChampionnat(Long idCourse, Long idChampionnat){
        Course course = courseRepository.findById(idCourse).get();
        Championnat championnat = championnatRepository.findById(idChampionnat).get();
        List<Course> courses = new ArrayList<>();
        if (championnat.getCourses() != null) {
            courses = championnat.getCourses();
        }
        courses.add(course);
        championnat.setCourses(courses);
        championnatRepository.save(championnat);
        return "Course affectée au championnat avec succès";
    }
    


}
