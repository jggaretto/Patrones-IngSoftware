package com.patronesingsoft.behavioral.Interpreter;

import java.util.Map;
import java.util.Objects;

/** EXPRESIÓN NO TERMINAL: delega en sus dos subexpresiones. */
public class Suma implements Expresion {
    private final Expresion izquierda;
    private final Expresion derecha;

    public Suma(Expresion izquierda, Expresion derecha) {
        this.izquierda = Objects.requireNonNull(izquierda);
        this.derecha = Objects.requireNonNull(derecha);
    }

    public int interpretar(Map<String, Integer> contexto) {
        return Math.addExact(izquierda.interpretar(contexto), derecha.interpretar(contexto));
    }
}
