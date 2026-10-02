package com.patronesingsoft.structural.Bridge;

import java.util.Objects;

/** ABSTRACCIÓN: los controles evolucionan independientemente de los dispositivos. */
public class ControlRemoto {
    protected final Dispositivo dispositivo;

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = Objects.requireNonNull(dispositivo);
    }

    public void alternarEncendido() {
        if (dispositivo.estaEncendido()) dispositivo.apagar();
        else dispositivo.encender();
    }

    public void ajustarVolumen(int volumen) { dispositivo.setVolumen(volumen); }
}
