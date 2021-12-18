package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UniqueName;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CreateCategoryDto {

    @NotBlank
    @UniqueName(message = "{category.name.unique}")
    private String name;

}
