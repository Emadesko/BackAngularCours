package com.emadesko.backangularcours.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nom;
    @Column(nullable = false)
    private Float prix;
    @Column(nullable = false)
    private Integer qteStock;
    @ManyToOne
    private Categorie categorie;
}
