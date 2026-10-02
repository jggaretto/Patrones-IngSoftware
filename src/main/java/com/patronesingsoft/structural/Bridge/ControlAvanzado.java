package com.patronesingsoft.structural.Bridge;

/** ABSTRACCIÓN REFINADA: agrega una función sin crear una subclase por dispositivo. */
public class ControlAvanzado extends ControlRemoto {
    public ControlAvanzado(Dispositivo dispositivo) { super(dispositivo); }
    public void silenciar() { dispositivo.setVolumen(0); }
}
