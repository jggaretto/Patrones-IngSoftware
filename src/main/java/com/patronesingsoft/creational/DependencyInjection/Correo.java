package com.patronesingsoft.creational.DependencyInjection;

/** DEPENDENCIA CONCRETA: simula un correo, sin utilizar servicios externos. */
public class Correo implements Notificador {
    @Override
    public String enviar(String alumno) {
        return "Correo de inscripcion para " + alumno;
    }
}
