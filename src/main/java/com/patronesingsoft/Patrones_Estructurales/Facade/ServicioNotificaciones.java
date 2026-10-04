package com.patronesingsoft.Patrones_Estructurales.Facade;

/**
 * Subsistema de notificaciones.
 */
public class ServicioNotificaciones {

    public void enviarBienvenida(String alumno, String legajo) {
        System.out.println("  [Notificaciones] Correo de bienvenida a " + alumno + " con legajo " + legajo);
    }

    public void enviarBaja(String alumno) {
        System.out.println("  [Notificaciones] Aviso de baja enviado a " + alumno);
    }
}