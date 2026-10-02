package com.patronesingsoft.behavioral.Interpreter;

import java.util.Map;

/** EXPRESIÓN TERMINAL: un literal ya contiene su valor. */
public class Numero implements Expresion {
    private final int valor;
    public Numero(int valor) { this.valor = valor; }
    public int interpretar(Map<String, Integer> contexto) { return valor; }
}
