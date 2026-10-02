package com.patronesingsoft.behavioral.Interpreter;

import java.util.Map;

/** CLIENTE: construye el árbol sintáctico e inicia su interpretación. */
public class Demo {
    public static void main(String[] args) {
        // ponytail: árbol construido a mano; agregar un parser si se reciben expresiones como texto.
        Expresion expresion = new Suma(new Variable("x"), new Suma(new Numero(3), new Numero(2)));
        assert expresion.interpretar(Map.of("x", 5)) == 10;
        assert expresion.interpretar(Map.of("x", 8)) == 13;
        boolean indefinida = false;
        try { expresion.interpretar(Map.of()); } catch (IllegalArgumentException e) { indefinida = true; }
        assert indefinida;
        boolean desbordamiento = false;
        try { new Suma(new Numero(Integer.MAX_VALUE), new Numero(1)).interpretar(Map.of()); }
        catch (ArithmeticException e) { desbordamiento = true; }
        assert desbordamiento;
        System.out.println("x + (3 + 2), con x = 5: " + expresion.interpretar(Map.of("x", 5)));
    }
}
