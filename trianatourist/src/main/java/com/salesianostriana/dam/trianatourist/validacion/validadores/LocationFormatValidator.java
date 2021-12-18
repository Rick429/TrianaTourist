package com.salesianostriana.dam.trianatourist.validacion.validadores;

import com.salesianostriana.dam.trianatourist.validacion.anotaciones.LocationFormat;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class LocationFormatValidator implements ConstraintValidator<LocationFormat, String> {

    @Override
    public void initialize(LocationFormat constraintAnnotation) {
    }
    @Override
    public boolean isValid(String location, ConstraintValidatorContext context) {
        String [] latlong=location.split(",");
        String lon=latlong[0];
        String lat=latlong[1];

        String lonMatch = "[\\-+]?(0?\\d{1,2}|0?\\d{1,2}\\.\\d{1,15}|1[0-7]?\\d|1[0-7]?\\d\\.\\d{1,15}|180|180\\.0{1,15})";
        String latMatch = "[\\-+]?([0-8]?\\d|[0-8]?\\d\\.\\d{1,15}|90|90\\.0{1,15})";

        if ((Pattern.matches(lonMatch, lon))&&(Pattern.matches(latMatch, lat))) {
            return true;
        }else{
            return false;
        }
    }
}
