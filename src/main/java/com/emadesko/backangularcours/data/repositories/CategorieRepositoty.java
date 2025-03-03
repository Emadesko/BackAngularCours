package com.emadesko.backangularcours.data.repositories;

import com.emadesko.backangularcours.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepositoty extends JpaRepository<Categorie, Long> {
}
