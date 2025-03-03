package com.emadesko.backangularcours.web.mappers;

import com.emadesko.backangularcours.data.entities.Categorie;
import com.emadesko.backangularcours.data.entities.Produit;
import com.emadesko.backangularcours.web.dtos.request.ProduitRequest;
import com.emadesko.backangularcours.web.dtos.response.ProduitResponse;

public class ProduitMapper {
    public static Produit toEntity(ProduitRequest produitRequest) {
        Categorie categorie = new Categorie();
        categorie.setId(produitRequest.getCategorieId());
        Produit produit = new Produit();
        produit.setNom(produitRequest.getNom());
        produit.setPrix(produitRequest.getPrix());
        produit.setQteStock(produitRequest.getQteStock());
        produit.setCategorie(categorie);
        return produit;
    }

    public static ProduitResponse toResponse(Produit produit) {
        return ProduitResponse.builder()
                .nom(produit.getNom())
                .id(produit.getId())
                .qteStock(produit.getQteStock())
                .prix(produit.getPrix())
                .categorieResponse(CategorieMapperI.toResponse(produit.getCategorie()))
                .build();
    }
}
