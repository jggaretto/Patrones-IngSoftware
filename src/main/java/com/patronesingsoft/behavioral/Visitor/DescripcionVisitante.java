package com.patronesingsoft.behavioral.Visitor;

/** VISITANTE CONCRETO: produce descripciones legibles para cada elemento. */
public class DescripcionVisitante implements Visitante {
    public String visitar(Documento documento) { return "Documento: " + documento.getPaginas() + " paginas"; }
    public String visitar(Imagen imagen) { return "Imagen: " + imagen.getTamanioKB() + " KB"; }
}
