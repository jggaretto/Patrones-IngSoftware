package com.patronesingsoft.structural.Decorator;

/** DECORADOR CONCRETO: agrega registro a cualquier combinación de notificadores. */
public class ConRegistro extends DecoradorNotificador {
    public ConRegistro(Notificador envuelto) { super(envuelto); }

    @Override
    public String enviar(String mensaje) {
        return envuelto.enviar(mensaje) + " | Registro: enviado";
    }
}
