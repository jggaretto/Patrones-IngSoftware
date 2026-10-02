package com.patronesingsoft.behavioral.Iterator;

import java.util.Iterator;
import java.util.List;

/** AGREGADO: ofrece iteradores sin exponer su representación interna. */
public class ColeccionLibros implements Iterable<String> {
    private final List<String> libros;

    public ColeccionLibros(List<String> libros) {
        this.libros = List.copyOf(libros);
        if (this.libros.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("Los titulos no pueden estar vacios");
        }
    }

    @Override
    public Iterator<String> iterator() { return new IteradorLibros(libros); }
}
