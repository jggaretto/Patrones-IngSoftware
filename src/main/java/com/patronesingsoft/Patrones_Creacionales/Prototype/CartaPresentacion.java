package com.patronesingsoft.Patrones_Creacionales.Prototype;

import java.util.List;

/**
 * PROTOTYPE concreto.
 */
public class CartaPresentacion extends Documento {

    public CartaPresentacion(String titulo, String contenido, List<String> etiquetas) {
        super(titulo, contenido, etiquetas);
    }

    @Override
    public String getTipo() {
        return "CartaPresentacion";
    }

    @Override
    public void personalized(String nombre) {
        setTitulo("Carta de presentacion de " + nombre);
    }

    @Override
    public CartaPresentacion clonar() {
        return (CartaPresentacion) super.clonar();
    }

    @Override
    public CartaPresentacion clonarProfundo() {
        return (CartaPresentacion) super.clonarProfundo();
    }
}