package com.emadesko.backangularcours.data.mock;

import com.emadesko.backangularcours.data.entities.Categorie;
import com.emadesko.backangularcours.data.entities.Produit;
import com.emadesko.backangularcours.data.repositories.CategorieRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CatégorieMock implements CommandLineRunner {
    private final CategorieRepositoty categorieRepositoty;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories = categorieRepositoty.findAll();
        if (categories.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                Categorie categorie = new Categorie();
                categorie.setNom("CATEGORIE " + (i+1));
                for (int j = 0; j < 10; j++) {
                    Produit produit = new Produit();
                    produit.setNom("PRODUIT " + (j+1) + " de " + categorie.getNom());
                    produit.setCategorie(categorie);
                    produit.setPrix((float)1000 * (i+1));
                    produit.setQteStock(10 * (i+1));
                    categorie.getProduits().add(produit);
                }
                categories.add(categorie);
            }
            categorieRepositoty.saveAllAndFlush(categories);
        }
    }
}
