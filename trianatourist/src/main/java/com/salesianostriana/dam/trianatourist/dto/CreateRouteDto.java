package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UniqueName;
import com.salesianostriana.dam.trianatourist.validacion.anotaciones.UniqueNameRoute;
import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public class CreateRouteDto {

    @UniqueNameRoute(message = "{route.name.uniqueNameRoute}")
    private String name;
}
