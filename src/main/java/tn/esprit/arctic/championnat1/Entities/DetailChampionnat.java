package tn.esprit.arctic.championnat1.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "DetailChampionnat")
public class DetailChampionnat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String stringCode;

    private String stringDescription;

    @OneToOne(mappedBy = "detailChampionnat")
    private Championnat championnat;
}