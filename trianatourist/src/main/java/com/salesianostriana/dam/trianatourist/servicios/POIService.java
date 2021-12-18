package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.dto.CreateCategoryDto;
import com.salesianostriana.dam.trianatourist.dto.CreatePOIDto;
import com.salesianostriana.dam.trianatourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.trianatourist.modelos.Category;
import com.salesianostriana.dam.trianatourist.modelos.POI;
import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import com.salesianostriana.dam.trianatourist.repositorios.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepository;

    public List<POI> findAll() {
        List<POI> lista = poiRepository.findAll();
        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }else{
            return lista;
        }
    }

    public POI findById (UUID id){
        return poiRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI edit (POI poi){
        return poiRepository.save(poi);
    }

    public POI save (POI poi){

        return poiRepository.save(poi);
    }

    public void deleteById (UUID id){
        poiRepository.deleteById(id);
    }
}
