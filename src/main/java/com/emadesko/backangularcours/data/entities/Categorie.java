package com.emadesko.backangularcours.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nom;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.PERSIST)
    private List<Produit> produits = new ArrayList<>();
}
