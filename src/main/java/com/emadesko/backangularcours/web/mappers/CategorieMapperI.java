package com.emadesko.backangularcours.web.mappers;

import com.emadesko.backangularcours.data.entities.Categorie;
import com.emadesko.backangularcours.web.dtos.request.CategorieRequest;
import com.emadesko.backangularcours.web.dtos.response.CategorieResponse;

public class CategorieMapperI {
    public static Categorie toEntity(final CategorieRequest categorieRequest) {
        Categorie categorie = new Categorie();
        categorie.setNom(categorieRequest.getNom());
        return categorie;
    }

    public static CategorieResponse toResponse(Categorie categorie) {
        return CategorieResponse.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .build();
    }
}
