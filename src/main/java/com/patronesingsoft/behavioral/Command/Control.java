package com.patronesingsoft.behavioral.Command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** INVOCADOR: ejecuta comandos y conserva su historial sin conocer la Luz. */
public class Control {
    private final Deque<Comando> historial = new ArrayDeque<>();

    public void ejecutar(Comando comando) {
        Objects.requireNonNull(comando).ejecutar();
        historial.push(comando);
    }

    public boolean deshacer() {
        if (historial.isEmpty()) return false;
        // Primero deshace; solo quita el historial si la operación tuvo éxito.
        historial.peek().deshacer();
        historial.pop();
        return true;
    }
}
