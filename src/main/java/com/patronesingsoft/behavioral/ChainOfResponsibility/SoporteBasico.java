package com.patronesingsoft.behavioral.ChainOfResponsibility;

/** MANEJADOR CONCRETO: resuelve el nivel inicial de soporte. */
public class SoporteBasico extends Soporte {
    public SoporteBasico(Soporte siguiente) { super(siguiente); }
    protected boolean puedeAtender(Solicitud solicitud) { return solicitud.nivel() == 1; }
    protected String resolver() { return "Atiende soporte basico"; }
}
