package com.patronesingsoft.behavioral.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** ITERADOR CONCRETO: cada instancia mantiene su propio cursor. */
public class IteradorLibros implements Iterator<String> {
    private final List<String> libros;
    private int posicion;

    public IteradorLibros(List<String> libros) { this.libros = List.copyOf(libros); }
    public boolean hasNext() { return posicion < libros.size(); }

    public String next() {
        if (!hasNext()) throw new NoSuchElementException("No quedan libros");
        return libros.get(posicion++);
    }
}
