package com.salesianostriana.dam.trianatourist.validacion.anotaciones;

import com.salesianostriana.dam.trianatourist.validacion.validadores.CategoryExistsValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryExistsValidator.class)
@Documented
public @interface CategoryExists {

    String message() default "La categoria no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
