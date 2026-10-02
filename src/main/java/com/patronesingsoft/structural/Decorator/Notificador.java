package com.patronesingsoft.structural.Decorator;

/** COMPONENTE: contrato compartido por el objeto base y todos los decoradores. */
public interface Notificador {
    String enviar(String mensaje);
}
