package tn.esprit.extest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.extest.Entities.Compte;

public interface CompteRepository extends JpaRepository< Compte,Long> {
}
