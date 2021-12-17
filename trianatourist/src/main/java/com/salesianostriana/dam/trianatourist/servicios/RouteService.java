package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.repositorios.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
}
