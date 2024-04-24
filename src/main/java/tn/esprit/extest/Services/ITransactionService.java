package tn.esprit.extest.Services;

import tn.esprit.extest.Entities.Transaction;

public interface ITransactionService {
    String ajouterVirement(Transaction transaction);
    void getAllTransactionByDate();
    String ajouterVersement(Transaction transaction);
    String ajouterRetrait(Transaction transaction);
}
