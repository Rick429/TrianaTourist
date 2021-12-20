package com.salesianostriana.dam.trianatourist.errores.excepciones;

public class EntityExistsException extends RuntimeException{
    public EntityExistsException(String message) {
        super(String.format(message));
    }
}
