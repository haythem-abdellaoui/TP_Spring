package tn.esprit.arctic.championnat1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sponsor")
public class Sponsor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "longIdSponsor")
    private Long longIdSponsor;

    private String stringNom;

    private String stringPays;

    private Float floatBudgetAnnuel;

    private Boolean booleanBloquerContrat;
    Boolean archived;
    LocalDate dateCreation;
    LocalDate dateDerniereModification;


    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contratList;
}