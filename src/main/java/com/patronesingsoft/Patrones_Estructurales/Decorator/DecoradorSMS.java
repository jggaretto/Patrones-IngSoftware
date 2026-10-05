package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * CONCRETE DECORATOR: agrega el envio por SMS.
 * Primero deja que el notificador envuelto haga lo suyo y despues suma el SMS.
 */
public class DecoradorSMS extends NotificadorDecorador {

    public DecoradorSMS(Notificador envuelto) {
        super(envuelto);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("  [SMS] " + mensaje);
    }
}
