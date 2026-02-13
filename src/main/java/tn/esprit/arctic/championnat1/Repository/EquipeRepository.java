package tn.esprit.arctic.championnat1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.arctic.championnat1.Entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
