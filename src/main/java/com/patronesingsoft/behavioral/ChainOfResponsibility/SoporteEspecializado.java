package com.patronesingsoft.behavioral.ChainOfResponsibility;

/** MANEJADOR CONCRETO: acepta consultas hasta nivel dos. */
public class SoporteEspecializado extends Soporte {
    public SoporteEspecializado(Soporte siguiente) { super(siguiente); }
    protected boolean puedeAtender(Solicitud solicitud) { return solicitud.nivel() <= 2; }
    protected String resolver() { return "Atiende soporte especializado"; }
}
