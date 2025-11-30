package org.talento.java.services;

import org.springframework.stereotype.Service;
import org.talento.java.dtos.category.CategoryRes;
import org.talento.java.mappers.CategoryMapper;
import org.talento.java.models.Category;
import org.talento.java.repositories.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.mapper = categoryMapper;
    }

    public List<CategoryRes> getAll() {
        List<Category> categories = this.categoryRepo.findAll();
        return this.mapper.toDto(categories);
    }
}
