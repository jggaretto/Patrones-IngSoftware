package com.patronesingsoft.creational.AbstractFactory;

/** FÁBRICA CONCRETA: crea los dos controles de la familia Windows. */
public class WindowsFactory implements GUIFactory {
    @Override
    public Boton crearBoton() {
        return new BotonWindows();
    }

    @Override
    public Casilla crearCasilla() {
        return new CasillaWindows();
    }
}