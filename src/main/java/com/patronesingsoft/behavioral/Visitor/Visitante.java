package com.patronesingsoft.behavioral.Visitor;

/** VISITANTE: declara una operación por cada tipo concreto de elemento. */
public interface Visitante {
    String visitar(Documento documento);
    String visitar(Imagen imagen);
}
