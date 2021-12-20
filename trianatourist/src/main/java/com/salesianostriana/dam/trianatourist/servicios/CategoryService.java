package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.dto.CategoryDtoConverter;
import com.salesianostriana.dam.trianatourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.trianatourist.dto.GetCategoryDto;
import com.salesianostriana.dam.trianatourist.dto.GetPOIDto;
import com.salesianostriana.dam.trianatourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import com.salesianostriana.dam.trianatourist.repositorios.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final POIRepository poiRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public List<Category> findAll() {
        List<Category> lista = categoryRepository.findAll();
        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return lista;
        }
    }

    public Category findById (UUID id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    public GetCategoryDto edit (CreateCategoryDto category, UUID id){
        Optional<Category> c = categoryRepository.findById(id);
        if(c.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        }else{
            c.get().setName(category.getName());
            return categoryDtoConverter.categoryToGetCategoryDto(categoryRepository.save(c.get()));
        }
    }

    public Category save (Category category){
        return categoryRepository.save(category);
    }

    public void deleteById (UUID id){
        if(categoryRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        }else{
            List<POI>pois = poiRepository.findByCategoryId(id);
            for (POI p: pois) {
                p.setCategory(null);
            }
            categoryRepository.deleteById(id);
        }

    }

   // public Category findByName(String name){ return categoryRepository.findByName(name); }
}
