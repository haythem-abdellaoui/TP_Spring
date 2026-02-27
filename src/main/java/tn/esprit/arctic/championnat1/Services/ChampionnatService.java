package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Repository.ChampionnatRepository;

@Service
@AllArgsConstructor
public class ChampionnatService implements IChampionnatService {
    
    private ChampionnatRepository championnatRepository;


}
