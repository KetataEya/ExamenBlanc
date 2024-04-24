package tn.esprit.extest.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.extest.Entities.Compte;
import tn.esprit.extest.Services.CompteService;

@RestController
@AllArgsConstructor
@RequestMapping("/compte")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @PostMapping("/ajout")
    Compte ajooutcompte(@RequestBody Compte compte, @RequestParam String agence){
        return compteService.ajouterCompteEtAffecterAAgence(compte,agence);
    }
}
