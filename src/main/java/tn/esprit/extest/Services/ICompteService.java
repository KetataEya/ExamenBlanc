package tn.esprit.extest.Services;

import tn.esprit.extest.Entities.Compte;

public interface ICompteService {
    Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
}
