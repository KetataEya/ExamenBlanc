package tn.esprit.extest.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.extest.Entities.Bank;
import tn.esprit.extest.Services.BankService;

@RestController
@AllArgsConstructor
@RequestMapping("/bank")
public class BankController {
    private BankService bankService;
    @PostMapping("/addbank")
    public Bank ajouterbank(@RequestBody Bank bank){
       return  bankService.ajouterBank(bank);

    }
}
