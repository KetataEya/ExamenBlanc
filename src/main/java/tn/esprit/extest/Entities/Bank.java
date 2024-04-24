package tn.esprit.extest.Entities;

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
public class Bank implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBank;
    String ncm;
    String agence;
    String adresse;
    @OneToMany( mappedBy= "bank")
    Set<Compte> comptes;
}
