package com.salesianostriana.dam.trianatourist.validacion.validadores;

import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private CategoryRepository repositorio;

    @Override
    public void initialize(UniqueName constraintAnnotation) { }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !repositorio.existsByName(name);
    }
}