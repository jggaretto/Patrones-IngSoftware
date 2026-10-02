package com.patronesingsoft.creational.AbstractFactory;

/** CLIENTE: elegir una fábrica cambia toda la familia, no solo un control. */
public class Demo {
    public static void main(String[] args) {
        GUIFactory mac = new MacFactory();
        GUIFactory windows = new WindowsFactory();
        assert mac.crearBoton() instanceof BotonMac;
        assert mac.crearCasilla() instanceof CasillaMac;
        assert windows.crearBoton() instanceof BotonWindows;
        assert windows.crearCasilla() instanceof CasillaWindows;
        new Aplicacion(mac).renderizar();
        new Aplicacion(windows).renderizar();
        System.out.println("Abstract Factory: familias compatibles verificadas.");
    }
}
