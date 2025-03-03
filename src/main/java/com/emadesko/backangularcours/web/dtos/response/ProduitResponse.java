package com.emadesko.backangularcours.web.dtos.response;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProduitResponse {
    private Long id;
    private String nom;
    private float prix;
    private int qteStock;
    private CategorieResponse categorieResponse;
}
