package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * CONCRETE DECORATOR: agrega el envio por WhatsApp.
 */
public class DecoradorWhatsapp extends NotificadorDecorador {

    public DecoradorWhatsapp(Notificador envuelto) {
        super(envuelto);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("  [WhatsApp] " + mensaje);
    }
}