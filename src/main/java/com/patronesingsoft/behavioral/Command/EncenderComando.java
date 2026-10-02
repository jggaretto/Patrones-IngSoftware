package com.patronesingsoft.behavioral.Command;

import java.util.Objects;

/** COMANDO CONCRETO: guarda el estado anterior para restaurarlo al deshacer. */
public class EncenderComando implements Comando {
    private final Luz luz;
    private boolean estadoAnterior;
    private boolean ejecutado;

    public EncenderComando(Luz luz) { this.luz = Objects.requireNonNull(luz); }

    public void ejecutar() {
        if (ejecutado) throw new IllegalStateException("Deshacer antes de reutilizar este comando");
        estadoAnterior = luz.estaEncendida();
        luz.setEncendida(true);
        ejecutado = true;
    }

    public void deshacer() {
        if (!ejecutado) throw new IllegalStateException("El comando no fue ejecutado");
        luz.setEncendida(estadoAnterior);
        ejecutado = false;
    }
}
