package com.patronesingsoft.Patrones_Estructurales.Decorator;

/** CONCRETE COMPONENT: la bebida base que se va a decorar. */
public class Cafe implements Bebida {
    public String descripcion() { return "Cafe"; }
    public double precio() { return 1000; }
}
