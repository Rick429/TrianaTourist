package com.salesianostriana.dam.trianatourist.validacion.anotaciones;

import com.salesianostriana.dam.trianatourist.validacion.validadores.UrlFormatValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlFormatValidator.class)
@Documented
public @interface UrlFormat {

    String message() default "El formato de url es incorrecto";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
