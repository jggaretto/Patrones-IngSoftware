package com.patronesingsoft.structural.Flyweight;

import java.util.Objects;

/** CONTEXTO: conserva la posición propia y referencia el estado compartido. */
public class Arbol {
    private final int x;
    private final int y;
    private final TipoArbol tipo;

    public Arbol(int x, int y, TipoArbol tipo) {
        this.x = x;
        this.y = y;
        this.tipo = Objects.requireNonNull(tipo);
    }

    public TipoArbol getTipo() { return tipo; }
    public String dibujar() { return tipo.dibujar(x, y); }
}
