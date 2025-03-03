package com.emadesko.backangularcours.web.controllers;

import com.emadesko.backangularcours.web.dtos.request.ProduitRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/produits")
public interface ProduitController {
    @GetMapping("")
    ResponseEntity<Map<String, Object>> getProduits(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    );

    @GetMapping("{id}")
    ResponseEntity<Map<String, Object>> getOne(@PathVariable Long id);

    @GetMapping("categorie/{id}")
    ResponseEntity<Map<String, Object>> getProduitsBycategorie(@PathVariable(name = "id") Long categorieId,
           @RequestParam(defaultValue = "1") int page,
           @RequestParam(defaultValue = "5") int size);

    @PostMapping("")
    ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ProduitRequest produitRequest, BindingResult bindingResult);

    @PutMapping("{id}")
    ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Valid @RequestBody ProduitRequest produitRequest, BindingResult bindingResult);

    @DeleteMapping("{id}")
    ResponseEntity<Map<String, Object>> delete(@PathVariable Long id);
}
