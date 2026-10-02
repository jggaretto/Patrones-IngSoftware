package com.patronesingsoft.behavioral.Memento;

/** MEMENTO: estado inmutable; el cuidador no tiene getters públicos. */
public final class Instantanea {
    private final Editor origen;
    private final String texto;

    Instantanea(Editor origen, String texto) {
        this.origen = origen;
        this.texto = texto;
    }

    boolean pertenece(Editor editor) { return origen == editor; }
    String getTexto() { return texto; }
}
