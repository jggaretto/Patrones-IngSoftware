package com.patronesingsoft.creational.AbstractFactory;

/** FÁBRICA ABSTRACTA: crea familias completas de botones y casillas. */
public interface GUIFactory {
    Boton crearBoton();
    Casilla crearCasilla();
}