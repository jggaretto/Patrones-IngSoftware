package com.patronesingsoft.structural.Proxy;

/** PROXY VIRTUAL: pospone la carga hasta que se necesita mostrar la imagen. */
public class ProxyImagen implements Imagen {
    private final String archivo;
    private ImagenReal real;

    public ProxyImagen(String archivo) {
        if (archivo == null || archivo.isBlank()) throw new IllegalArgumentException("Archivo requerido");
        this.archivo = archivo;
    }

    // ponytail: inicialización diferida en un hilo; sincronizar si se comparte entre hilos.
    @Override
    public String mostrar() {
        if (real == null) real = new ImagenReal(archivo);
        return real.mostrar();
    }

    public boolean estaCargada() { return real != null; }
    ImagenReal getReal() { return real; }
}
