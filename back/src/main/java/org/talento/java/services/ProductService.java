package org.talento.java.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.talento.java.dtos.products.ProductReq;
import org.talento.java.dtos.PageRes;
import org.talento.java.dtos.products.ProductRes;
import org.talento.java.exceptions.NonExistentProductException;
import org.talento.java.mappers.ProductMapper;
import org.talento.java.models.Category;
import org.talento.java.models.Product;
import org.talento.java.repositories.CategoryRepo;
import org.talento.java.repositories.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo products;
    private final CategoryRepo categories;
    private final ProductMapper mapper;

    public ProductService(ProductRepo products, CategoryRepo categories, ProductMapper mapper) {
        this.products = products;
        this.categories = categories;
        this.mapper = mapper;
    }

    @Transactional
    public ProductRes create(ProductReq productDto) {
        Long categoryId = productDto.categoryId();
        Product product = this.mapper.toEntity(productDto);
        Category category = this.categories.getReferenceById(categoryId);

        product.setCategory(category);
        return this.mapper.toDto(this.products.save(product));
    }

    public PageRes<ProductRes> findBy(String search, Pageable pageable) {
        var page = this.products.findBy(search, pageable);
        return this.mapper.toPageRes(search, page);
    }

    public ProductRes getById(Long id) {
        return this.products.findById(id)
            .map(this.mapper::toDto)
            .orElseThrow(NonExistentProductException::new);
    }

    @Transactional
    public ProductRes update(Long id, ProductReq productDto) {
        return this.products.findById(id).map(product -> {
            Long categoryId = productDto.categoryId();
            Category category = this.categories.getReferenceById(categoryId);

            this.mapper.updateFromDto(productDto, product);
            product.setCategory(category);

            return this.mapper.toDto(this.products.save(product));
        }).orElseThrow(NonExistentProductException::new);
    }

    public void delete(Long id) {
        if (!this.products.existsById(id)) {
            throw new NonExistentProductException();
        }

        this.products.deleteById(id);
    }
}
