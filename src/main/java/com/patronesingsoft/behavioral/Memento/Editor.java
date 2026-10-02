package com.patronesingsoft.behavioral.Memento;

import java.util.Objects;

/** ORIGINADOR: es responsable de crear y restaurar sus propias instantáneas. */
public class Editor {
    private String texto = "";

    public void escribir(String texto) { this.texto = Objects.requireNonNull(texto); }
    public String getTexto() { return texto; }
    public Instantanea guardar() { return new Instantanea(this, texto); }

    public void restaurar(Instantanea instantanea) {
        Objects.requireNonNull(instantanea);
        if (!instantanea.pertenece(this)) throw new IllegalArgumentException("Instantanea de otro editor");
        texto = instantanea.getTexto();
    }
}
