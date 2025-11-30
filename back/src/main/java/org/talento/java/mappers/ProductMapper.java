package org.talento.java.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import org.talento.java.dtos.products.ProductReq;
import org.talento.java.dtos.PageRes;
import org.talento.java.dtos.products.ProductRes;
import org.talento.java.models.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
        @Mapping(target = "ratingRate", source = "rating.rate"),
        @Mapping(target = "ratingCount", source = "rating.count"),
        @Mapping(target = "category", ignore = true)
    })
    void updateFromDto(ProductReq dto, @MappingTarget Product entity);

    @Mappings({
        @Mapping(target = "ratingRate", source = "rating.rate"),
        @Mapping(target = "ratingCount", source = "rating.count"),
        @Mapping(target = "category", ignore = true)
    })
    Product toEntity(ProductReq dto);

    @Mapping(target = "rating", expression = "java(new ProductRes.RatingRes(product))")
    ProductRes toDto(Product product);

    @Mapping(target = "pagination", expression = "java(new PageRes.Pagination(page))")
    @Mapping(target = "content", source = "page.content", defaultExpression = "java(java.util.List.of())")
    PageRes<ProductRes> toPageRes(String query, Page<Product> page);
}
