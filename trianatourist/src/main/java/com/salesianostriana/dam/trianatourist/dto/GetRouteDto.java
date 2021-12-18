package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.modelos.POI;
import lombok.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetRouteDto{

    private UUID id;
    private String name;
    private List<POI> steps;
}
