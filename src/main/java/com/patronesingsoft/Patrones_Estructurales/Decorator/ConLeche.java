package com.patronesingsoft.Patrones_Estructurales.Decorator;

/** DECORATOR: envuelve una Bebida y le suma leche. */
public class ConLeche implements Bebida {
    private final Bebida bebida;

    public ConLeche(Bebida bebida) { this.bebida = bebida; }

    public String descripcion() { return bebida.descripcion() + " + leche"; }
    public double precio() { return bebida.precio() + 300; }
}
