package com.proyecto.spotify.exception;

public class ModeloNotFoundException extends RuntimeException{

    public ModeloNotFoundException(String message) {
        super(message);
    }
}
