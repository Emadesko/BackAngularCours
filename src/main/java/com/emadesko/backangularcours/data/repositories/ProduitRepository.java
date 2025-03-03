package com.emadesko.backangularcours.data.repositories;

import com.emadesko.backangularcours.data.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> getProduitByCategorie_Id(Long categorieId);
    Page<Produit> getProduitByCategorie_Id(Long categorieId, Pageable pageable);
}
