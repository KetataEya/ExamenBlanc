package tn.esprit.extest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTransaction;
    double montant;
    @Enumerated(EnumType.STRING)
    TypeTransaction type;
    LocalDate dateTransaction;
    @ManyToOne
            @JsonIgnore
    Compte expediteur;
    @ManyToOne
            @JsonIgnore
    Compte destinataire;
}
