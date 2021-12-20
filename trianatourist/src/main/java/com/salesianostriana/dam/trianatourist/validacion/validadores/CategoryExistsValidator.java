package com.salesianostriana.dam.trianatourist.validacion.validadores;

import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.CategoryExists;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class CategoryExistsValidator implements ConstraintValidator<CategoryExists, UUID> {

    @Autowired
    private CategoryRepository repositorio;

    @Override
    public void initialize(CategoryExists constraintAnnotation) { }

    @Override
    public boolean isValid(UUID id, ConstraintValidatorContext context) {
        return repositorio.existsById(id);
    }
}
