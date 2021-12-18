package com.salesianostriana.dam.trianatourist.errores.excepciones;

public class EntityExistsException extends RuntimeException{
    public EntityExistsException() {
        super(String.format("El punto de interes ya esta agregado en la ruta"));
    }
}
