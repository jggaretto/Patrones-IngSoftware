package com.patronesingsoft.creational.DependencyInjection;

/** DEPENDENCIA: contrato que necesita el servicio para enviar una confirmación. */
public interface Notificador {
    String enviar(String alumno);
}
