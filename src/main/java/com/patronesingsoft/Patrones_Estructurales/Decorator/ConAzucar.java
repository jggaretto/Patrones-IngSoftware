package com.patronesingsoft.Patrones_Estructurales.Decorator;

/** DECORATOR: envuelve una Bebida y le suma azucar. */
public class ConAzucar implements Bebida {
    private final Bebida bebida;

    public ConAzucar(Bebida bebida) { this.bebida = bebida; }

    public String descripcion() { return bebida.descripcion() + " + azucar"; }
    public double precio() { return bebida.precio() + 100; }
}
