package com.patronesingsoft.behavioral.ChainOfResponsibility;

import java.util.Objects;

/** MANEJADOR: atiende la solicitud o la pasa al siguiente eslabón. */
public abstract class Soporte {
    private final Soporte siguiente;

    protected Soporte(Soporte siguiente) { this.siguiente = siguiente; }

    public String atender(Solicitud solicitud) {
        Objects.requireNonNull(solicitud);
        if (puedeAtender(solicitud)) return resolver();
        return siguiente == null ? "Sin responsable para ese nivel" : siguiente.atender(solicitud);
    }

    protected abstract boolean puedeAtender(Solicitud solicitud);
    protected abstract String resolver();
}
