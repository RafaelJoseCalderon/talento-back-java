package org.talento.java.mappers;

import org.mapstruct.Mapper;
import org.talento.java.dtos.category.CategoryRes;
import org.talento.java.models.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryRes> toDto(List<Category> order);
}
