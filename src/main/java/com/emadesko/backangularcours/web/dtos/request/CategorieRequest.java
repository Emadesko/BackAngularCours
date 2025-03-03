package com.emadesko.backangularcours.web.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorieRequest {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
}
