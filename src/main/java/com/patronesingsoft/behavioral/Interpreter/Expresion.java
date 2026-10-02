package com.patronesingsoft.behavioral.Interpreter;

import java.util.Map;

/** EXPRESIÓN ABSTRACTA: cada regla sabe interpretar su parte del lenguaje. */
public interface Expresion {
    int interpretar(Map<String, Integer> contexto);
}
