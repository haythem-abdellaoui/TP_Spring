package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Services.IPositionService;

@RestController
@AllArgsConstructor
public class PositionController {
    
    private IPositionService positionService;
    


}
