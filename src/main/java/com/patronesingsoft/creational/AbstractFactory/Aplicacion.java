package com.patronesingsoft.creational.AbstractFactory;

/** CLIENTE: consume una familia de controles sin conocer su sistema operativo. */
public class Aplicacion {
    private final Boton boton;
    private final Casilla casilla;

    public Aplicacion(GUIFactory factory) {
        this.boton = factory.crearBoton();
        this.casilla = factory.crearCasilla();
    }

    public void renderizar() {
        boton.pintar();
        casilla.pintar();
    }

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        GUIFactory factory = os.contains("mac") ? new MacFactory() : new WindowsFactory();

        Aplicacion app = new Aplicacion(factory);
        app.renderizar();
    }
}