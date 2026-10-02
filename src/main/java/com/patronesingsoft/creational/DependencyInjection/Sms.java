package com.patronesingsoft.creational.DependencyInjection;

/** DEPENDENCIA CONCRETA: permite cambiar el canal sin modificar el servicio. */
public class Sms implements Notificador {
    @Override
    public String enviar(String alumno) {
        return "SMS de inscripcion para " + alumno;
    }
}
