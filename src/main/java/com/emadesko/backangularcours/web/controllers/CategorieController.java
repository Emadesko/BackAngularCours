package com.emadesko.backangularcours.web.controllers;

import com.emadesko.backangularcours.web.dtos.request.CategorieRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/categories")
public interface CategorieController {
    @GetMapping("")
    ResponseEntity<Map<String, Object>> getCategories(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    );

    @GetMapping("{id}")
    ResponseEntity<Map<String, Object>> getOne(@PathVariable int id);

    @PostMapping("")
    ResponseEntity<Map<String, Object>> create(@Valid @RequestBody CategorieRequest categorieRequest, BindingResult bindingResult);

    @PutMapping("{id}")
    ResponseEntity<Map<String, Object>> update(@PathVariable int id, @Valid @RequestBody CategorieRequest categorieRequest, BindingResult bindingResult);

    @DeleteMapping("{id}")
    ResponseEntity<Map<String, Object>> delete(@PathVariable int id);
}
