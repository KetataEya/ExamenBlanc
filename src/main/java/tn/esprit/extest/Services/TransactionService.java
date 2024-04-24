package tn.esprit.extest.Services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.extest.Entities.Compte;
import tn.esprit.extest.Entities.Transaction;
import tn.esprit.extest.Entities.TypeCompte;
import tn.esprit.extest.Entities.TypeTransaction;
import tn.esprit.extest.Repositories.CompteRepository;
import tn.esprit.extest.Repositories.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService{
    private CompteService compteService;
    private CompteRepository compteRepository;
    private TransactionRepository transactionRepository;


    @Override
    public String ajouterVirement(Transaction transaction) {
        if(transaction.getType() == TypeTransaction.VIREMENT && transaction.getExpediteur().getType()== TypeCompte.EPARGNE){
            return "On ne peutpas faire un virement à partir d’un compte épargne";
        }
        if (transaction.getType()==TypeTransaction.VIREMENT
                &&transaction.getExpediteur().getType()== TypeCompte.COURANT
                &&transaction.getMontant()>transaction.getExpediteur().getSolde()){
            return "One ne peut pas faire un virement : Solde insuffisant";
        }
        Compte compteExpediteur = compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        Compte compteDestinataire = compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);

        compteExpediteur.setSolde(compteExpediteur.getSolde()-transaction.getMontant());
        compteDestinataire.setSolde(compteDestinataire.getSolde()+transaction.getMontant());

        compteRepository.save(compteExpediteur);
        compteRepository.save(compteDestinataire);
        transactionRepository.save(transaction);

        return "Virement de "+ transaction.getMontant() + "DT de compte "
                +compteExpediteur.getCode()+ "vers le compte "
                +compteDestinataire.getCode()+ "approuvé avec succès";
    }
    public String ajouterRetrait(Transaction transaction) {
        if (transaction.getType() != TypeTransaction.RETRAIT) {
            return "Type de transaction invalide";
        }
        Compte compteExpediteur = compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);


        if ( compteExpediteur == null ) {
            return "Compte expéditeur invalide";
        }

        double montant = transaction.getMontant();

        if ( compteExpediteur.getSolde() < montant) {
            return "On ne peut pas faire un retrait : Solde insuffisant";
        }

        compteExpediteur.setSolde( compteExpediteur.getSolde() - montant);

        transactionRepository.save(transaction);

        return "RETRAIT de " + montant + " DT de compte " +  compteExpediteur.getCode() + " approuvé avec succès.";
    }
    @Override
    public String ajouterVersement(Transaction transaction) {
        Compte compteDestinataire =
                compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);
        if (transaction.getType()== TypeTransaction.VERSEMENT
                &&compteDestinataire.getType()==TypeCompte.COURANT){
            transaction.setDateTransaction(LocalDate.now());
            compteDestinataire.setSolde(compteDestinataire.getSolde()+transaction.getMontant()-2);

            compteRepository.save(compteDestinataire);
            transactionRepository.save(transaction);
            return "Versement de"+transaction.getMontant()+" DT de compte "+compteDestinataire.getCode()+" approuvé avec succès.";
        }
        transaction.setDateTransaction(LocalDate.now());
        compteDestinataire.setSolde(compteDestinataire.getSolde()+transaction.getMontant());
        compteRepository.save(compteDestinataire);
        transactionRepository.save(transaction);
        return "Versement de"+transaction.getMontant()+" DT de compte "+compteDestinataire.getCode()+" approuvé avec succès sans frais.";
    }
@Scheduled(fixedRate = 30000)
    @Override
    public void getAllTransactionByDate() {
        LocalDate today = LocalDate.now();
        List<Transaction> transactions = transactionRepository.findTransactionByDateTransaction(today);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    }

