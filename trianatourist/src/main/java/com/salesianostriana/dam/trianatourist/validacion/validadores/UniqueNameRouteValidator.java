package com.salesianostriana.dam.trianatourist.validacion.validadores;

import com.salesianostriana.dam.trianatourist.repositorios.RouteRepository;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UniqueNameRoute;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameRouteValidator implements ConstraintValidator<UniqueNameRoute, String> {

    @Autowired
    private RouteRepository repositorio;

    @Override
    public void initialize(UniqueNameRoute constraintAnnotation) { }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !repositorio.existsByName(name);
    }
}
