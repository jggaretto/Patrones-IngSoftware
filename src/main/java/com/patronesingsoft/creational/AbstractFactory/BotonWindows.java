package com.patronesingsoft.creational.AbstractFactory;

/** PRODUCTO CONCRETO: botón de la familia Windows. */
public class BotonWindows implements Boton {
    @Override
    public void pintar() {
        System.out.println("Renderizando botón estilo Windows");
    }
}