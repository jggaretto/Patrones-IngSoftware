package com.patronesingsoft.behavioral.Mediator;

/** MEDIADOR: contrato de comunicación entre colegas. */
public interface Mediador {
    void registrar(Usuario usuario);
    void enviar(String mensaje, Usuario emisor);
}
