package com.emadesko.backangularcours.web.controllers.impl;

import com.emadesko.backangularcours.data.entities.Produit;
import com.emadesko.backangularcours.services.ProduitService;
import com.emadesko.backangularcours.web.controllers.ProduitController;
import com.emadesko.backangularcours.web.dtos.request.ProduitRequest;
import com.emadesko.backangularcours.web.dtos.response.ProduitResponse;
import com.emadesko.backangularcours.web.dtos.response.RequestResponse;
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
public class ProduitControllerImpl implements ProduitController {

    private final ProduitService produitService;

    @Override
    public ResponseEntity<Map<String, Object>> getProduits(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Produit> produits = produitService.findAll(pageable);
        Page<ProduitResponse> produitsResponse = produits.map(ProduitMapper::toResponse);
        return new ResponseEntity<>(RequestResponse.response(
                HttpStatus.OK,
                produitsResponse,
                "ProduitResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(Long id) {
        var produit = produitService.getById(id);
        if (produit == null) {
            return new ResponseEntity<>(RequestResponse.response(
                    HttpStatus.NOT_FOUND,
                    "Ce produit n'existe pas",
                    "NOT_FOUND"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(RequestResponse.response(
                HttpStatus.OK,
                ProduitMapper.toResponse(produit),
                "ProduitResponse"),
            HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getProduitsBycategorie(Long categorieId, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Produit> produits = produitService.getProduitByCategorie_Id(categorieId, pageable);
        Page<ProduitResponse> produitsResponse = produits.map(ProduitMapper::toResponse);
        return new ResponseEntity<>(RequestResponse.response(
                HttpStatus.OK,
                produitsResponse,
                "ProduitResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(ProduitRequest produitRequest, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(Long id, ProduitRequest produitRequest, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> delete(Long id) {
        return null;
    }
}
