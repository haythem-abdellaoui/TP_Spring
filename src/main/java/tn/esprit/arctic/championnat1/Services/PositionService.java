package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat1.Repository.PositionRepository;

@Service
@AllArgsConstructor
public class PositionService implements IPositionService {
    
    private PositionRepository positionRepository;
    


}
