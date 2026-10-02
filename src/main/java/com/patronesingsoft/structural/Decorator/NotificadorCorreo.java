package com.patronesingsoft.structural.Decorator;

/** COMPONENTE CONCRETO: comportamiento base de notificación. */
public class NotificadorCorreo implements Notificador {
    @Override
    public String enviar(String mensaje) { return "Correo: " + mensaje; }
}
