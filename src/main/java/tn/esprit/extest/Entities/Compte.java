package tn.esprit.extest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Compte implements Serializable {
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long idCompte;
   @Enumerated(EnumType.STRING)
    TypeCompte type;
    Long code;
    double solde;
    @ManyToOne
            @JsonIgnore
    Bank bank;
    @OneToMany(mappedBy = "expediteur")
    Set<Transaction> tran_exp;

    @OneToMany(mappedBy = "destinataire")
    Set<Transaction> tran_dest;

}
