package com.patronesingsoft.creational.AbstractFactory;

/** PRODUCTO CONCRETO: casilla de la familia macOS. */
public class CasillaMac implements Casilla {
    @Override
    public void pintar() {
        System.out.println("Renderizando casilla estilo macOS");
    }
}
