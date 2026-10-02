package com.patronesingsoft.structural.Bridge;

/** IMPLEMENTACIÓN CONCRETA: estado de un radio simulado. */
public class Radio implements Dispositivo {
    private boolean encendido;
    private int volumen;

    public void encender() { encendido = true; }
    public void apagar() { encendido = false; }
    public boolean estaEncendido() { return encendido; }
    public int getVolumen() { return volumen; }
    public void setVolumen(int volumen) {
        if (volumen < 0 || volumen > 100) throw new IllegalArgumentException("Volumen entre 0 y 100");
        this.volumen = volumen;
    }
}
