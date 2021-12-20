package com.salesianostriana.dam.trianatourist.controladores;

import com.salesianostriana.dam.trianatourist.dto.*;
import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.servicios.CategoryService;
import com.salesianostriana.dam.trianatourist.servicios.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;
    private final POIDtoConverter poiDtoConverter;

    @GetMapping("/")
    public List<GetPOIDto> findAll(){
        return poiService.findAll();
    }

    @GetMapping("/{id}")
    public GetPOIDto findByID(@PathVariable UUID id){
        return poiDtoConverter.pOIToGeTPOIDto(poiService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<POI> crear(@Valid @RequestBody CreatePOIDto c){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(poiService.save(poiDtoConverter.createPOIDtoToPOI(c)));
    }

    @PutMapping("/{id}")
    public GetPOIDto edit(@Valid @RequestBody CreatePOIDto cdto, @PathVariable UUID id){
        return poiService.edit(cdto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        poiService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
