package org.talento.java.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talento.java.dtos.products.ProductReq;
import org.talento.java.dtos.PageRes;
import org.talento.java.dtos.products.ProductRes;
import org.talento.java.responses.ResponseDelete;
import org.talento.java.services.ProductService;

@RestController @RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<ProductRes> createProduct(
        @RequestBody @Valid ProductReq product
    ) {
        var response = this.productService.create(product);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "all")
    public ResponseEntity<PageRes<ProductRes>> getAll(
        @RequestParam(value = "query", defaultValue = "") String search,
        @PageableDefault(size = 5) Pageable pageable
    ) {
        var response = this.productService.findBy(search, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ProductRes> getById(
        @PathVariable Long id
    ) {
        var response = this.productService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "update/{id}")
    ResponseEntity<ProductRes> update(
        @PathVariable Long id,
        @RequestBody @Valid ProductReq product
    ) {
        var response = this.productService.update(id, product);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<ResponseDelete> delete(
        @PathVariable Long id,
        HttpServletRequest request
    ) {
        this.productService.delete(id);
        return ResponseDelete.of(request, "Product disposed correctly");
    }
}
