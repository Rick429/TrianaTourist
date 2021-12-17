package com.salesianostriana.dam.trianatourist.controladores;

import com.salesianostriana.dam.trianatourist.servicios.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;
}