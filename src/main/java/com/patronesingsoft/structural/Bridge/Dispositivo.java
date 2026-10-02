package com.patronesingsoft.structural.Bridge;

/** IMPLEMENTACIÓN: operaciones que ofrece cualquier dispositivo. */
public interface Dispositivo {
    void encender();
    void apagar();
    boolean estaEncendido();
    void setVolumen(int volumen);
    int getVolumen();
}
