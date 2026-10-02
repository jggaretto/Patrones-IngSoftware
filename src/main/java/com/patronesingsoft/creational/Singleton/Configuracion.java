package com.patronesingsoft.creational.Singleton;

/** SINGLETON: configuración inmutable compartida dentro de la JVM. */
public final class Configuracion {
    // La inicialización de clases de Java publica esta instancia de forma segura.
    private static final Configuracion INSTANCIA = new Configuracion();
    private final String nombreAplicacion = "Campus virtual";

    private Configuracion() { }

    public static Configuracion getInstancia() { return INSTANCIA; }
    public String getNombreAplicacion() { return nombreAplicacion; }
}
