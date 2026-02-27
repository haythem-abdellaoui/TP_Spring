package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Repository.DetailChampionnatRepository;

@Service
@AllArgsConstructor
public class DetailChampionnatService implements IDetailChampionnatService {
    
    private DetailChampionnatRepository detailChampionnatRepository;
    
  

}
