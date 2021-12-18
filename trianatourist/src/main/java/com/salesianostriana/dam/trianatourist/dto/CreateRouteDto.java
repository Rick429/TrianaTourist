package com.salesianostriana.dam.trianatourist.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public class CreateRouteDto {

    private String name;
}
