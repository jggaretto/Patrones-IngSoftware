package com.patronesingsoft.Patrones_Estructurales.Decorator;

public class DecoradorWhatsapp {
    
}
package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * CONCRETE DECORATOR: agrega el envio por WhatsApp.
 */
public class DecoradorWhatsApp extends NotificadorDecorador {

    public DecoradorWhatsApp(Notificador envuelto) {
        super(envuelto);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("  [WhatsApp] " + mensaje);
    }
}
