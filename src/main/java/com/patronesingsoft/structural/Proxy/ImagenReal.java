package com.patronesingsoft.structural.Proxy;

/** SUJETO REAL: simula una carga costosa al crearse. */
public class ImagenReal implements Imagen {
    private final String archivo;

    public ImagenReal(String archivo) {
        this.archivo = archivo;
        System.out.println("Cargando imagen: " + archivo);
    }

    @Override
    public String mostrar() { return "Mostrando " + archivo; }
}
