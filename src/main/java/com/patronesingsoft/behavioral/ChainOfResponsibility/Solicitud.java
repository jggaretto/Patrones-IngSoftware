package com.patronesingsoft.behavioral.ChainOfResponsibility;

/** PETICIÓN: nivel requerido por una consulta de soporte. */
public record Solicitud(int nivel) {
    public Solicitud {
        if (nivel < 1 || nivel > 3) throw new IllegalArgumentException("Nivel entre 1 y 3");
    }
}
