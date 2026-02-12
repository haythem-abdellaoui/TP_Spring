package tn.esprit.arctic.championnat1.Entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contratList;
}