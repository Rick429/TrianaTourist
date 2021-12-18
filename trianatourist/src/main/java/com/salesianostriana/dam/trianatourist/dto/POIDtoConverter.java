package com.salesianostriana.dam.trianatourist.dto;

import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.servicios.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor @Log
public class POIDtoConverter {

    private final CategoryService categoryService;

    public POI createPOIDtoToPOI(CreatePOIDto createPOIDto){
        Category cat = categoryService.findByName(createPOIDto.getName());
        return POI.builder()
                .name(createPOIDto.getName())
                .date(createPOIDto.getDate())
                .location(createPOIDto.getLocation())
                .category(cat)
                .coverPhoto(createPOIDto.getCoverPhoto())
                .photo2(createPOIDto.getPhoto2())
                .photo3(createPOIDto.getPhoto3())
                .build();
    }

    public GetPOIDto pOIToGeTPOIDto(POI poi){
        return GetPOIDto.builder()
                .id(poi.getId())
                .name(poi.getName())
                .category(poi.getCategory().getName())
                .coverPhoto(poi.getCoverPhoto())
                .date(poi.getDate())
                .location(poi.getLocation())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .build();
    }
}
