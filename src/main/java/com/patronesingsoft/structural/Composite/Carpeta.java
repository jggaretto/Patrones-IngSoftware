package com.patronesingsoft.structural.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** COMPUESTO: agrupa hojas y otros compuestos bajo el mismo contrato. */
public class Carpeta implements ElementoArchivo {
    private final List<ElementoArchivo> elementos = new ArrayList<>();

    public void agregar(ElementoArchivo elemento) {
        Objects.requireNonNull(elemento);
        if (elemento instanceof Carpeta carpeta && carpeta.contiene(this)) {
            throw new IllegalArgumentException("La jerarquia no puede tener ciclos");
        }
        elementos.add(elemento);
    }

    // ponytail: busca ciclos recorriendo subcarpetas; mantener padres si el árbol crece mucho.
    private boolean contiene(Carpeta buscada) {
        if (this == buscada) return true;
        for (ElementoArchivo elemento : elementos) {
            if (elemento instanceof Carpeta carpeta && carpeta.contiene(buscada)) return true;
        }
        return false;
    }

    @Override
    public long getTamanio() {
        long total = 0;
        for (ElementoArchivo elemento : elementos) {
            // No necesita distinguir Archivo de Carpeta.
            total = Math.addExact(total, elemento.getTamanio());
        }
        return total;
    }
}
