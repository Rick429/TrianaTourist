package com.salesianostriana.dam.trianatourist.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetCategoryDto {

    private UUID id;
    private String name;
}
