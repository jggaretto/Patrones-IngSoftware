package com.patronesingsoft.behavioral.Visitor;

import java.util.Objects;

/** ELEMENTO CONCRETO: despacha al método del visitante que recibe Documento. */
public class Documento implements Elemento {
    private final int paginas;

    public Documento(int paginas) {
        if (paginas <= 0) throw new IllegalArgumentException("Paginas positivas requeridas");
        this.paginas = paginas;
    }

    public int getPaginas() { return paginas; }
    public String aceptar(Visitante visitante) { return Objects.requireNonNull(visitante).visitar(this); }
}
