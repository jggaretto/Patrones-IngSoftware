package com.patronesingsoft.structural.Flyweight;

import java.util.Objects;

/** FLYWEIGHT: estado intrínseco compartido e inmutable. */
public final class TipoArbol {
    private final String especie;

    public TipoArbol(String especie) { this.especie = Objects.requireNonNull(especie); }
    public String dibujar(int x, int y) { return especie + " en (" + x + ", " + y + ")"; }
}
