package com.salesianostriana.dam.trianatourist.validacion.validadores;

import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UrlFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlFormatValidator implements ConstraintValidator<UrlFormat, String> {

    @Override
    public void initialize(UrlFormat constraintAnnotation) { }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        if(!url.isEmpty()){
            Pattern p = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");
            Matcher hasUrl = p.matcher(url);
            if (hasUrl.find()) {
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }

    }
}
