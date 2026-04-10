package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import tn.esprit.arctic.championnat1.Entities.Contrat;
import tn.esprit.arctic.championnat1.Entities.Sponsor;
import tn.esprit.arctic.championnat1.Repository.SponsorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SponsorService implements ISponsorService{
    
    private SponsorRepository sp;


    @Override
    public Sponsor ajouterSponsor(Sponsor sponsor) {


        return sp.save(sponsor);
    }

    @Override
    public List<Sponsor> ajouterSponsors(List<Sponsor> sponsors) {
        return sp.saveAll(sponsors);
    }

    @Override
    public Sponsor modifierSponsor(Sponsor sponsor) {
        return sp.save(sponsor);
    }

    @Override
    public void supprimerSponsor(Long idSponsor) {
        sp.deleteById(idSponsor);

    }

    @Override
    public List<Sponsor> listSponsors() {

        return  sp.findAll();
    }

    @Override
    public Sponsor recupererSponsor(Long idSponsor) {

        return sp.findById(idSponsor).orElse(null);
    }

    @Override
    public Boolean archiverSponsor(Long idSponsor) {
        Sponsor sponsor=sp.findById(idSponsor).orElse(null);
sponsor.setArchived(Boolean.TRUE);
       sp.save(sponsor);
       return sponsor.getArchived();
    }

    @Override
    public double pourcentageBudgetAnnuelConsomme(Long idSponsor, int annee) {
        Sponsor sponsor = sp.findById(idSponsor).orElse(null);
        if (sponsor == null || sponsor.getFloatBudgetAnnuel() == null || sponsor.getFloatBudgetAnnuel() == 0) {
            return 0;
        }

        double totalContrats = 0;
        if (sponsor.getContratList() != null) {
            for (Contrat contrat : sponsor.getContratList()) {
                Integer anneeContrat = parseAnnee(contrat.getStringAnnee());
                if (anneeContrat != null && anneeContrat == annee && contrat.getFloatMontant() != null) {
                    totalContrats += contrat.getFloatMontant();
                }
            }
        }

        return (totalContrats * 100.0) / sponsor.getFloatBudgetAnnuel();
    }

    private Integer parseAnnee(String annee) {
        if (annee == null || annee.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(annee.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
