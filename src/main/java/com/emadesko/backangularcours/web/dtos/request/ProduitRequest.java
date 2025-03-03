package com.emadesko.backangularcours.web.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProduitRequest {
    @NotEmpty(message = "Le nom est obligatoire")
    private String nom;
    @NotEmpty(message = "Le prix est obligatoire")
    private float prix;
    @NotEmpty(message = "La quantité en stock est obligatoire")
    private int qteStock;
    @NotEmpty(message = "L'id de la categorie est obligatopire")
    private Long categorieId;
}
