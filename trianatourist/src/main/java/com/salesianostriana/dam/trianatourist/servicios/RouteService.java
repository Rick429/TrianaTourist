package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.dto.CreatePOIDto;
import com.salesianostriana.dam.trianatourist.dto.CreateRouteDto;
import com.salesianostriana.dam.trianatourist.dto.GetRouteDto;
import com.salesianostriana.dam.trianatourist.dto.RouteDtoConverter;
import com.salesianostriana.dam.trianatourist.errores.excepciones.EntidadNoEncontradaException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.EntityExistsException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.modelos.Route;
import com.salesianostriana.dam.trianatourist.repositorios.POIRepository;
import com.salesianostriana.dam.trianatourist.repositorios.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteDtoConverter routeDtoConverter;
    private final POIRepository poiRepository;

    public List<Route> findAll() {
        List<Route> lista = routeRepository.findAll();
        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }else{
            return lista;
        }
    }

    public Route findById (UUID id){
        return routeRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public GetRouteDto edit (CreateRouteDto route, UUID id){
        Optional<Route> r = routeRepository.findById(id);
        if(r.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        }else{
            r.get().setName(route.getName());
            return routeDtoConverter.routeToGetRouteDto(routeRepository.save(r.get()));
        }

    }

    public Route save (Route route){
        return routeRepository.save(route);
    }

    public void deleteById (UUID id){
        if(routeRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        }else{
            routeRepository.deleteById(id);
        }

    }

    public ResponseEntity<Route> addPOIToRoute(@PathVariable UUID id, @PathVariable UUID id2){
        Optional<Route> r = routeRepository.findById(id);
        Optional<POI> p = poiRepository.findById(id2);
        if(r.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        }else if(p.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
        }else{
            if(r.get().getSteps().contains(p.get())){
                throw new EntityExistsException("El punto de interes ya esta agregado en la ruta");
            }else{
                r.get().getSteps().add(p.get());
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(routeRepository.save(r.get()));
            }
        }
    }

    public ResponseEntity<?> RemovePOIToRoute(@PathVariable UUID id, @PathVariable UUID id2){
        Optional<Route> r = routeRepository.findById(id);
        Optional<POI> p = poiRepository.findById(id2);
        if(r.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        }else if(p.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
        }else{
            if(!r.get().getSteps().contains(p.get())){
                throw new EntidadNoEncontradaException("El punto de interes no esta agregado en la ruta");
            }else{
                r.get().getSteps().remove(p.get());
                routeRepository.save(r.get());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

        }
    }
}
