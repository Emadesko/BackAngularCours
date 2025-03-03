package com.emadesko.backangularcours.services.impl;

import com.emadesko.backangularcours.data.entities.Categorie;
import com.emadesko.backangularcours.data.entities.Produit;
import com.emadesko.backangularcours.data.repositories.CategorieRepositoty;
import com.emadesko.backangularcours.data.repositories.ProduitRepository;
import com.emadesko.backangularcours.services.CategorieService;
import com.emadesko.backangularcours.services.ProduitService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategorieServiceImpl extends ServiceImpl<Categorie> implements CategorieService {
    private final CategorieRepositoty categorieRepositoty;

    public CategorieServiceImpl(CategorieRepositoty categorieRepositoty) {
        super(categorieRepositoty);
        this.categorieRepositoty = categorieRepositoty;
    }

    @Override
    public Categorie update(Long id, Categorie categorie) {
        Categorie data = categorieRepositoty.findById(id).orElse(null);
        if(data==null) {
            return null;
        }
        return categorieRepositoty.save(data);
    }
}
