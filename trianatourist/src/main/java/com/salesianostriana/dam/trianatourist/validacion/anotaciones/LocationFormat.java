package com.salesianostriana.dam.trianatourist.validacion.anotaciones;

import com.salesianostriana.dam.trianatourist.validacion.validadores.LocationFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocationFormatValidator.class)
@Documented
public @interface LocationFormat {

    String message() default "La ubicación no es válida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
