package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.repositorios.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepository;
}
