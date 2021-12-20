package com.salesianostriana.dam.trianatourist.validacion.anotaciones;

import com.salesianostriana.dam.trianatourist.validacion.validadores.UniqueNameRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameRouteValidator.class)
@Documented
public @interface UniqueNameRoute {

    String message() default "El nombre de la ruta debe ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
