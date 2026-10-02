package com.patronesingsoft.behavioral.Command;

/** RECEPTOR: contiene el estado sobre el que actúan los comandos. */
public class Luz {
    private boolean encendida;
    public boolean estaEncendida() { return encendida; }
    public void setEncendida(boolean encendida) { this.encendida = encendida; }
}
