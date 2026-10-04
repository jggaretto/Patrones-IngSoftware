package com.patronesingsoft.Patrones_Creacionales.Prototype;

import java.util.List;

/**
 * PROTOTYPE concreto.
 */
public class Informe extends Documento {

    public Informe(String titulo, String contenido, List<String> etiquetas) {
        super(titulo, contenido, etiquetas);
    }

    @Override
    public String getTipo() {
        return "Informe";
    }

    @Override
    public void personalized(String nombre) {
        setTitulo("Informe de " + nombre);
    }

    @Override
    public Informe clonar() {
        return (Informe) super.clonar();
    }

    @Override
    public Informe clonarProfundo() {
        return (Informe) super.clonarProfundo();
    }
}