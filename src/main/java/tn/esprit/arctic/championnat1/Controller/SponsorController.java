package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Services.ISponsorService;

@RestController
@AllArgsConstructor
public class SponsorController {
    
    private ISponsorService sponsorService;


}
