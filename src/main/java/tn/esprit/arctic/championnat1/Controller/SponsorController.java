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

    @PutMapping("/modifySponsor")
    public Sponsor modifySponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.modifierSponsor(sponsor);
    }

    @DeleteMapping("/deleteSponsor/{id}")
    public void deleteSponsor(@PathVariable("id") Long idSponsor) {
        sponsorService.supprimerSponsor(idSponsor);
    }

    @GetMapping("/listSponsors")
    public List<Sponsor> listSponsors() {
        return sponsorService.listSponsors();
    }

    @GetMapping("/get_sponsor/{id}")
    public Sponsor getSponsor(@PathVariable("id") Long idSponsor) {
        return sponsorService.recupererSponsor(idSponsor);
    }

    @PutMapping("/archiver/{id}")
    public Boolean archiver(@PathVariable("id") Long idSponsor) {
        return sponsorService.archiverSponsor(idSponsor);
    }


}
