package tn.esprit.extest.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.extest.Entities.Bank;
import tn.esprit.extest.Repositories.BankRepository;
@Service
@AllArgsConstructor
public class BankService implements IBankService{
    @Autowired
    private BankRepository bankRepository;
    public Bank ajouterBank(Bank bank){
        return bankRepository.save(bank);
    }
}
