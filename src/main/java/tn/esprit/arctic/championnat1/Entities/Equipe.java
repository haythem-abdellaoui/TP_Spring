package tn.esprit.arctic.championnat1.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Equipe")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "longIdEquipe")
    private Long longIdEquipe;

    private String stringLibelle;

    private Integer integerNbPointsTotal;

    private Integer integerClassementGeneral;

    @OneToMany(mappedBy = "equipe")
    private List<Pilote> piloteList;

    @OneToMany(mappedBy = "equipe")
    private List<Contrat> contratList;
}