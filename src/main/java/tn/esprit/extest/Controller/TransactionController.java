package tn.esprit.extest.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.extest.Entities.Compte;
import tn.esprit.extest.Entities.Transaction;
import tn.esprit.extest.Services.CompteService;
import tn.esprit.extest.Services.TransactionService;

@RestController
@AllArgsConstructor
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/ajoutVir")
    String ajoutVir(@RequestBody Transaction transaction){
        return transactionService.ajouterVirement(transaction);
    }

    @PostMapping("/retrait")
    public String ajouterRetrait(@RequestBody Transaction transaction) {
        return transactionService.ajouterRetrait(transaction);
    }
    @PostMapping("/versment")
    public String ajouterVersement(Transaction transaction){
        return transactionService.ajouterVersement(transaction);
    }
@GetMapping("/getAll")
    public void getalltrans(){
         transactionService.getAllTransactionByDate();
}

}
