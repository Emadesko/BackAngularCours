package com.emadesko.backangularcours.services;

import com.emadesko.backangularcours.data.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProduitService extends Service<Produit> {
    List<Produit> getProduitByCategorie_Id(Long id);
    Page<Produit> getProduitByCategorie_Id(Long id, Pageable pageable);
}
