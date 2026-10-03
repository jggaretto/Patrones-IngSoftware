package com.patronesingsoft.Patrones_de_Comportamiento.Chain_of_Responsability;

public abstract class Soporte {
    protected Soporte siguiente;

    // Conecta este eslabón con el siguiente de la cadena
    public Soporte setSiguiente(Soporte siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public abstract void atender(int nivel, String problema);
}
