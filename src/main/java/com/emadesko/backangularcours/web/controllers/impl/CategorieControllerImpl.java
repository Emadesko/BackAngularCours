package com.emadesko.backangularcours.web.controllers.impl;

import com.emadesko.backangularcours.data.entities.Categorie;
import com.emadesko.backangularcours.data.entities.Produit;
import com.emadesko.backangularcours.services.CategorieService;
import com.emadesko.backangularcours.web.controllers.CategorieController;
import com.emadesko.backangularcours.web.dtos.request.CategorieRequest;
import com.emadesko.backangularcours.web.dtos.response.CategorieResponse;
import com.emadesko.backangularcours.web.dtos.response.ProduitResponse;
import com.emadesko.backangularcours.web.dtos.response.RequestResponse;
import com.emadesko.backangularcours.web.mappers.CategorieMapperI;
import com.emadesko.backangularcours.web.mappers.ProduitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CategorieControllerImpl implements CategorieController {

    private final CategorieService categorieService;
    @Override
    public ResponseEntity<Map<String, Object>> getCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Categorie> categories = categorieService.findAll(pageable);
        Page<CategorieResponse> categoriesResponse = categories.map(CategorieMapperI::toResponse);
        return new ResponseEntity<>(RequestResponse.response(
                HttpStatus.OK,
                categoriesResponse,
                "CategorieResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(int id) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(CategorieRequest categorieRequest, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(int id, CategorieRequest categorieRequest, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> delete(int id) {
        return null;
    }
}
