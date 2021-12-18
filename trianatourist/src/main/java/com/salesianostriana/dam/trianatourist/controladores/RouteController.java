package com.salesianostriana.dam.trianatourist.controladores;

import com.salesianostriana.dam.trianatourist.dto.*;
import com.salesianostriana.dam.trianatourist.errores.excepciones.EntityExistsException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.modelos.Route;
import com.salesianostriana.dam.trianatourist.servicios.POIService;
import com.salesianostriana.dam.trianatourist.servicios.RouteService;
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
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;
    private final RouteDtoConverter routeDtoConverter;
    private final POIDtoConverter poiDtoConverter;
    private final POIService poiService;

    @GetMapping("/")
    public List<GetRouteDto> findAll(){
        return routeService.findAll().stream()
                .map(routeDtoConverter::routeToGetRouteDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Route findByID(@PathVariable UUID id){
        return routeService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Route> crear(@Valid @RequestBody CreateRouteDto c){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(routeService.save(routeDtoConverter.createRouteDtoToRoute(c)));
    }

    @PutMapping("/{id}")
    public CreateRouteDto edit(@Valid @RequestBody CreateRouteDto cdto, @PathVariable UUID id){
        Route r = routeService.findById(id);
        r.setName(cdto.getName());
        routeService.edit(r);
        return cdto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        if(routeService.findById(id)!=null){
            routeService.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/poi")
    public ResponseEntity<Route> addPOIToRoute(@PathVariable UUID id, @Valid @RequestBody CreatePOIDto createPOIDto){
        Route r = routeService.findById(id);
        POI p = poiDtoConverter.createPOIDtoToPOI(createPOIDto);
        if(r.getSteps().contains(p)){
            throw new EntityExistsException();
        }else{
            r.getSteps().add(p);

            poiService.save(p);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(routeService.save(r));
        }
    }

    @PostMapping("/{id}/poi/{id2}")
    public ResponseEntity<Route> addPOIToRoute(@PathVariable UUID id, @PathVariable UUID id2){
        Route r = routeService.findById(id);
        POI p = poiService.findById(id2);
        if(r.getSteps().contains(p)){
            throw new EntityExistsException();
        }else{
        r.getSteps().add(p);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(routeService.save(r));
        }
    }

    @DeleteMapping("/{id}/poi/{id2}")
    public ResponseEntity<?> RemovePOIToRoute(@PathVariable UUID id, @PathVariable UUID id2){
        Route r = routeService.findById(id);
        POI p = poiService.findById(id2);
        r.getSteps().remove(p);
        routeService.save(r);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
