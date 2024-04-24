package tn.esprit.extest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.extest.Entities.Bank;

import java.util.List;

public interface BankRepository extends JpaRepository< Bank,Long> {
    Bank findBanksByAgence(String agence);
}
