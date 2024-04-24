package tn.esprit.extest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.extest.Entities.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository< Transaction,Long> {
    List<Transaction> findTransactionByDateTransaction(LocalDate Date);
}
