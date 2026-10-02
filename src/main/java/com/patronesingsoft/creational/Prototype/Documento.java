package com.patronesingsoft.creational.Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** PROTOTIPO CONCRETO: copia el título y una lista independiente de etiquetas. */
public class Documento implements Prototipo<Documento> {
    private String titulo;
    private final List<String> etiquetas;

    public Documento(String titulo, List<String> etiquetas) {
        this.titulo = Objects.requireNonNull(titulo);
        this.etiquetas = new ArrayList<>(List.copyOf(etiquetas));
    }

    @Override
    public Documento copiar() {
        // El constructor copia la lista: modificar la copia no modifica el original.
        return new Documento(titulo, etiquetas);
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = Objects.requireNonNull(titulo); }
    public List<String> getEtiquetas() { return List.copyOf(etiquetas); }
    public void agregarEtiqueta(String etiqueta) { etiquetas.add(Objects.requireNonNull(etiqueta)); }
}
