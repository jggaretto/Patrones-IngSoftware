package com.patronesingsoft.structural.Decorator;

/** DECORADOR CONCRETO: suma un canal conservando el comportamiento previo. */
public class ConSms extends DecoradorNotificador {
    public ConSms(Notificador envuelto) { super(envuelto); }

    @Override
    public String enviar(String mensaje) {
        return envuelto.enviar(mensaje) + " | SMS: " + mensaje;
    }
}
