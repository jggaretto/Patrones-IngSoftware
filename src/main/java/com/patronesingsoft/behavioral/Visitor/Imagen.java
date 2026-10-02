package com.patronesingsoft.behavioral.Visitor;

import java.util.Objects;

/** ELEMENTO CONCRETO: despacha al método del visitante que recibe Imagen. */
public class Imagen implements Elemento {
    private final int tamanioKB;

    public Imagen(int tamanioKB) {
        if (tamanioKB <= 0) throw new IllegalArgumentException("Tamanio positivo requerido");
        this.tamanioKB = tamanioKB;
    }

    public int getTamanioKB() { return tamanioKB; }
    public String aceptar(Visitante visitante) { return Objects.requireNonNull(visitante).visitar(this); }
}
