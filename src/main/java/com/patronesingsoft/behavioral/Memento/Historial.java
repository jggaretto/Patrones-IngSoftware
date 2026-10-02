package com.patronesingsoft.behavioral.Memento;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** CUIDADOR: conserva instantáneas sin leer su contenido. */
public class Historial {
    private final Editor editor;
    private final Deque<Instantanea> estados = new ArrayDeque<>();

    public Historial(Editor editor) { this.editor = Objects.requireNonNull(editor); }
    public void respaldar() { estados.push(editor.guardar()); }

    public boolean deshacer() {
        if (estados.isEmpty()) return false;
        editor.restaurar(estados.peek());
        estados.pop();
        return true;
    }
}
