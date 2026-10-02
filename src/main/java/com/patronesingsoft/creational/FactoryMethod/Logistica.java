package com.patronesingsoft.creational.FactoryMethod;

/** CREADOR: conserva el flujo y delega la elección del producto a sus subclases. */
public abstract class Logistica {
    public String planificarEntrega() {
        return crearTransporte().entregar();
    }

    // Este método es el Factory Method: las subclases deciden qué crear.
    protected abstract Transporte crearTransporte();
}
