package tn.esprit.arctic.championnat1.Services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.arctic.championnat1.Entities.Contrat;
import tn.esprit.arctic.championnat1.Entities.Sponsor;
import tn.esprit.arctic.championnat1.Repository.ContratRepository;

import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratSchedulerService {

	private final ContratRepository contratRepository;
	private final ISponsorService sponsorService;

	@Scheduled(fixedRate = 30000)
	@Transactional
	public void archiverContratsExpireesEtAffichageContratsActifsParEquipe() {
		int anneeCourante = Year.now().getValue();
		List<Contrat> contrats = contratRepository.findAll();

		for (Contrat contrat : contrats) {
			Integer anneeContrat = parseAnnee(contrat.getStringAnnee());
			if (anneeContrat != null && anneeContrat < anneeCourante) {
				contrat.setBooleanArchived(true);
			}
		}

		contratRepository.saveAll(contrats);

		for (Contrat contrat : contrats) {
			if (Boolean.TRUE.equals(contrat.getBooleanArchived())) {
				continue;
			}
			if (contrat.getEquipe() == null || contrat.getSponsor() == null) {
				continue;
			}

			System.out.println("L'equipe " + contrat.getEquipe().getStringLibelle()
					+ " a un contrat d'un montant de " + contrat.getFloatMontant()
					+ " avec le sponsor " + contrat.getSponsor().getStringNom());
		}
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

	@Scheduled(cron = "0 0 9 ? * MON", zone = "Africa/Tunis")
	@Transactional
	public void afficherPourcentageBudgetSponsors() {
		int anneeCourante = Year.now().getValue();
		List<Sponsor> sponsors = sponsorService.listSponsors();

		for (Sponsor sponsor : sponsors) {
			double pourcentage = sponsorService.pourcentageBudgetAnnuelConsomme(sponsor.getLongIdSponsor(), anneeCourante);
			System.out.println("Sponsor " + sponsor.getStringNom() + " pourcentage : " + pourcentage);

			if (pourcentage > 70 && pourcentage < 100) {
				System.out.println("attention budget presque consomme : " + pourcentage + " % !");
			} else if (pourcentage > 100) {
				System.out.println("budget depasse!! vous ne pouvez plus faire de contrats");
				sponsor.setBooleanBloquerContrat(true);
				sponsorService.modifierSponsor(sponsor);
			}
		}
	}
}

