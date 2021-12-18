package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.modelos.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category createCategoryDtoToCategory (CreateCategoryDto createCategoryDto){
        return Category.builder()
                .name(createCategoryDto.getName())
                .build();
    }

    public GetCategoryDto categoryToGetCategoryDto(Category category){
        return GetCategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
