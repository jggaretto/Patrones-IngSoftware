package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * CONCRETE DECORATOR: marca el mensaje como urgente.
 *
 * A diferencia de los otros dos, este decorador NO agrega un canal nuevo sino
 * que TRANSFORMA el mensaje ANTES de delegar. Por eso el orden en que se
 * apilan los decoradores cambia el resultado (ver Caso 4 del Main).
 */
public class DecoradorUrgente extends NotificadorDecorador {

    public DecoradorUrgente(Notificador envuelto) {
        super(envuelto);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar("[URGENTE] " + mensaje.toUpperCase());
    }
}
