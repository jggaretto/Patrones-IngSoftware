package com.patronesingsoft.behavioral.Interpreter;

import java.util.Map;
import java.util.Objects;

/** EXPRESIÓN TERMINAL: busca su valor en el contexto. */
public class Variable implements Expresion {
    private final String nombre;

    public Variable(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
        this.nombre = nombre;
    }

    public int interpretar(Map<String, Integer> contexto) {
        Integer valor = Objects.requireNonNull(contexto).get(nombre);
        if (valor == null) throw new IllegalArgumentException("Variable no definida: " + nombre);
        return valor;
    }
}
