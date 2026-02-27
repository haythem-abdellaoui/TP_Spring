package tn.esprit.arctic.championnat1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.championnat1.Entities.Sponsor;
import tn.esprit.arctic.championnat1.Services.ISponsorService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sponsors")
public class SponsorController {
    
    private ISponsorService sponsorService;
    @PostMapping("/add")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.ajouterSponsor(sponsor);
    }

    @PostMapping("/addSponsors")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> sponsors) {
        return sponsorService.ajouterSponsors(sponsors);
    }


}
