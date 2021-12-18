package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

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

    public Category edit (Category category){
        return categoryRepository.save(category);
    }

    public Category save (Category category){
        return categoryRepository.save(category);
    }

    public void deleteById (UUID id){
        categoryRepository.deleteById(id);
    }

    public Category findByName(String name){ return categoryRepository.findByName(name); }
}
