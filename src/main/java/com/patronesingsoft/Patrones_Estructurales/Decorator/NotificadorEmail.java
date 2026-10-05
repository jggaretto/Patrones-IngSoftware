package com.patronesingsoft.Patrones_Estructurales.Decorator;

/**
 * CONCRETE COMPONENT (Componente concreto).
 *
 * Es el objeto base al que se le van a ir agregando responsabilidades.
 * Por defecto, toda notificacion sale solo por email.
 */
public class NotificadorEmail implements Notificador {

    @Override
    public void enviar(String mensaje) {
        System.out.println("  [Email] " + mensaje);
    }
}
