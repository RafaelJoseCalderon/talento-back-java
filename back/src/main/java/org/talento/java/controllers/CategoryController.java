package org.talento.java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.talento.java.dtos.category.CategoryRes;
import org.talento.java.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<CategoryRes>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
