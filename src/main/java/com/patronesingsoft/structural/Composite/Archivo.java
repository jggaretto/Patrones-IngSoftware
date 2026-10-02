package com.patronesingsoft.structural.Composite;

/** HOJA: calcula su tamaño sin delegar en otros elementos. */
public class Archivo implements ElementoArchivo {
    private final long tamanio;

    public Archivo(long tamanio) {
        if (tamanio < 0) throw new IllegalArgumentException("Tamanio no negativo requerido");
        this.tamanio = tamanio;
    }

    @Override
    public long getTamanio() { return tamanio; }
}
