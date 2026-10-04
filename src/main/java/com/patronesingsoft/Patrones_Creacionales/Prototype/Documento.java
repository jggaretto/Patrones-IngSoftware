package com.patronesingsoft.Patrones_Creacionales.Prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * PROTOTYPE (abstracto).
 *
 * La clase define la "operación de clonado" y sirve como modelo base.
 * Cada objeto concreto sabe copiarse a si mismo: el cliente nunca necesita
 * conocer los detalles de la copia, solo pide un clon.
 *
 * Se implementa Cloneable para poder usar Object.clone(), que es una copia
 * superficial (shallow copy): copia los campos de referencia tal cual.
 */
public abstract class Documento implements Cloneable {

    private String titulo;
    private String contenido;

    // Referencia mutable: es la que permite ver la diferencia entre
    // copia superficial y copia profunda.
    private List<String> etiquetas;

    protected Documento(String titulo, String contenido, List<String> etiquetas) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.etiquetas = new ArrayList<>(etiquetas);
    }

    // -----------------------------------------------------------------
    // OPERACIÓN DEL PROTOTIPO
    // -----------------------------------------------------------------

    /**
     * Copia superficial. Object.clone() duplica la referencia al campo
     * "etiquetas": el clon y el original COMPARTEN la misma lista.
     */
    public Documento clonar() {
        try {
            return (Documento) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Documento debe implementar Cloneable", e);
        }
    }

    /**
     * Copia profunda. Tras clonar, se crea una lista nueva para el clon,
     * de modo que ya no comparte estado con el original.
     */
    public Documento clonarProfundo() {
        Documento copia = clonar();
        copia.etiquetas = new ArrayList<>(this.etiquetas);
        return copia;
    }

    // -----------------------------------------------------------------
    // Comportamiento específico de cada tipo de documento
    // -----------------------------------------------------------------

    public abstract String getTipo();

    public abstract void personalized(String nombre);

    // -----------------------------------------------------------------
    // Getters / Setters
    // -----------------------------------------------------------------

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    @Override
    public String toString() {
        return getTipo() + "{titulo='" + titulo + "'"
                + ", contenido='" + contenido + "'"
                + ", etiquetas=" + etiquetas
                + ", idObjeto=" + System.identityHashCode(this)
                + ", idEtiquetas=" + System.identityHashCode(etiquetas)
                + "}";
    }
}