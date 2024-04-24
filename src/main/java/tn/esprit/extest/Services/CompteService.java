package tn.esprit.extest.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.extest.Entities.Bank;
import tn.esprit.extest.Entities.Compte;
import tn.esprit.extest.Repositories.BankRepository;
import tn.esprit.extest.Repositories.CompteRepository;
@Service
@AllArgsConstructor
public class CompteService implements ICompteService{
    private BankRepository bankRepository;
    private CompteRepository compteRepository;
    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        Bank bank = bankRepository.findBanksByAgence(agenceBank);
        compte.setBank(bank);
        bank.getComptes().add(compte);
        return compteRepository.save(compte);
    }
}
