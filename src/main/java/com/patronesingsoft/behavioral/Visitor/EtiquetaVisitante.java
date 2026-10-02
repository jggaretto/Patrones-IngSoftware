package com.patronesingsoft.behavioral.Visitor;

/** VISITANTE CONCRETO: incorpora otra operación sin cambiar los elementos. */
public class EtiquetaVisitante implements Visitante {
    public String visitar(Documento documento) { return "DOC[" + documento.getPaginas() + "]"; }
    public String visitar(Imagen imagen) { return "IMG[" + imagen.getTamanioKB() + "]"; }
}
