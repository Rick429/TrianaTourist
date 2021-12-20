package com.salesianostriana.dam.trianatourist.controladores;

import com.salesianostriana.dam.trianatourist.dto.CategoryDtoConverter;
import com.salesianostriana.dam.trianatourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.trianatourist.dto.GetCategoryDto;
import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.servicios.CategoryService;
import com.salesianostriana.dam.trianatourist.servicios.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryDtoConverter categoryDtoConverter;
    private final POIService poiService;

    @GetMapping("/")
    public List<GetCategoryDto> findAll(){
        return categoryService.findAll().stream()
                .map(categoryDtoConverter::categoryToGetCategoryDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Category findByID(@PathVariable UUID id){
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Category> crear(@Valid @RequestBody CreateCategoryDto c){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.save(categoryDtoConverter.createCategoryDtoToCategory(c)));
    }

    @PutMapping("/{id}")
    public CreateCategoryDto edit(@Valid @RequestBody CreateCategoryDto cdto, @PathVariable UUID id){
        Category c = categoryService.findById(id);
        c.setName(cdto.getName());
        categoryService.edit(c);
        return cdto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
