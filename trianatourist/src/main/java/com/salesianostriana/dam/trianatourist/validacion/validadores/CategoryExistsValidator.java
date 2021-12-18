package com.salesianostriana.dam.trianatourist.validacion.validadores;

import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.CategoryExists;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryExistsValidator implements ConstraintValidator<CategoryExists, String> {

    @Autowired
    private CategoryRepository repositorio;

    @Override
    public void initialize(CategoryExists constraintAnnotation) { }

    @Override
    public boolean isValid(String category, ConstraintValidatorContext context) {
        return repositorio.existsByName(category);
    }
}
