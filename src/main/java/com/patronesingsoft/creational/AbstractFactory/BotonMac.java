package com.patronesingsoft.creational.AbstractFactory;

/** PRODUCTO CONCRETO: botón de la familia macOS. */
public class BotonMac implements Boton {
    @Override
    public void pintar() {
        System.out.println("Renderizando botón estilo macOS");
    }
}
