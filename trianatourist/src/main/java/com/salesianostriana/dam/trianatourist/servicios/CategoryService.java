package com.salesianostriana.dam.trianatourist.servicios;

import com.salesianostriana.dam.trianatourist.repositorios.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
}
