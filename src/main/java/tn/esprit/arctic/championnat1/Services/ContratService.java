package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Repository.ContratRepository;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {
    
    private ContratRepository contratRepository;
    


}
