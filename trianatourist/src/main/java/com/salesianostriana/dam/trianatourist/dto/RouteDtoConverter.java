package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.modelos.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route createRouteDtoToRoute (CreateRouteDto createRouteDto){
        return Route.builder()
                .name(createRouteDto.getName())
                .build();
    }

    public GetRouteDto routeToGetRouteDto (Route route){
        return GetRouteDto.builder()
                .id(route.getId())
                .name(route.getName())
                .steps(route.getSteps())
                .build();
    }
}
