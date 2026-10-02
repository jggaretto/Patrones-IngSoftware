package com.patronesingsoft.creational.AbstractFactory;

/** FÁBRICA CONCRETA: crea los dos controles de la familia macOS. */
public class MacFactory implements GUIFactory {
    @Override
    public Boton crearBoton() {
        return new BotonMac();
    }

    @Override
    public Casilla crearCasilla() {
        return new CasillaMac();
    }
}