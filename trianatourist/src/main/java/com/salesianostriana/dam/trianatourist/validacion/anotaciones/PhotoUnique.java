package com.salesianostriana.dam.trianatourist.validacion.anotaciones;

import com.salesianostriana.dam.trianatourist.validacion.validadores.PhotoUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhotoUniqueValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhotoUnique {

    String message() default "Los valores de los campos no coinciden";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();
    String photo2();
    String photo3();
}
