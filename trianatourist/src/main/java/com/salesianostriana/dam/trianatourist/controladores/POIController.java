package com.salesianostriana.dam.trianatourist.controladores;

import com.salesianostriana.dam.trianatourist.servicios.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;
}
