package com.patronesingsoft.behavioral.Visitor;

/** ELEMENTO: acepta una operación externa representada por un visitante. */
public interface Elemento {
    String aceptar(Visitante visitante);
}
