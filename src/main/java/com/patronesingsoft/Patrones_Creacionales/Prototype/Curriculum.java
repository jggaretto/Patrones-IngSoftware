package com.patronesingsoft.Patrones_Creacionales.Prototype;

import java.util.List;

/**
 * PROTOTYPE concreto.
 */
public class Curriculum extends Documento {

    public Curriculum(String titulo, String contenido, List<String> etiquetas) {
        super(titulo, contenido, etiquetas);
    }

    @Override
    public String getTipo() {
        return "Curriculum";
    }

    @Override
    public void personalized(String nombre) {
        setTitulo("Curriculum de " + nombre);
    }

    @Override
    public Curriculum clonar() {
        return (Curriculum) super.clonar();
    }

    @Override
    public Curriculum clonarProfundo() {
        return (Curriculum) super.clonarProfundo();
    }
}