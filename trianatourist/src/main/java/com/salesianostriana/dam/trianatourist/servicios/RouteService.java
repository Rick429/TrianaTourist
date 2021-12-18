package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.dto.CreatePOIDto;
import com.salesianostriana.dam.trianatourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.modelos.Route;
import com.salesianostriana.dam.trianatourist.repositorios.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

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

    public Route edit (Route route){
        return routeRepository.save(route);
    }

    public Route save (Route route){
        return routeRepository.save(route);
    }

    public void deleteById (UUID id){
        routeRepository.deleteById(id);
    }
}
