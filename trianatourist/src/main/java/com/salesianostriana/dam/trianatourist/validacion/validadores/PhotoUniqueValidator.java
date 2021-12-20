package com.salesianostriana.dam.trianatourist.validacion.validadores;


import com.salesianostriana.dam.trianatourist.validacion.anotaciones.PhotoUnique;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PhotoUniqueValidator implements ConstraintValidator<PhotoUnique, Object> {

    private String coverPhoto;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(PhotoUnique constraintAnnotation) {
        this.coverPhoto = constraintAnnotation.coverPhoto();
        this.photo2 = constraintAnnotation.photo2();
        this.photo3 = constraintAnnotation.photo3();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        String field1 = (String)PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(coverPhoto);
        String field2 = (String)PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2);
        String field3 = (String)PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3);

        if(!field2.isEmpty()||!field3.isEmpty()){
            if (!field1.equals(field2)&&!field1.equals(field3)&&!field2.equals(field3)) {
                return true;
            } else {
                return false;
            }
        }else{
            return true;
        }

    }
}
