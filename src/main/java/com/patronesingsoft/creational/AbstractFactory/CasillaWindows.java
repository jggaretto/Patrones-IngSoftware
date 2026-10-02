package com.patronesingsoft.creational.AbstractFactory;

/** PRODUCTO CONCRETO: casilla de la familia Windows. */
public class CasillaWindows implements Casilla {
    @Override
    public void pintar() {
        System.out.println("Renderizando casilla estilo Windows");
    }
}