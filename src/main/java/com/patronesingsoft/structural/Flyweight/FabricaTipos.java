package com.patronesingsoft.structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

/** FÁBRICA: devuelve el mismo tipo para una misma especie. */
public class FabricaTipos {
    private final Map<String, TipoArbol> tipos = new HashMap<>();

    // ponytail: caché por especie y de un hilo; limitarla y sincronizar si hay entradas no acotadas.
    public TipoArbol obtener(String especie) {
        if (especie == null || especie.isBlank()) throw new IllegalArgumentException("Especie requerida");
        return tipos.computeIfAbsent(especie, TipoArbol::new);
    }

    public int cantidadTipos() { return tipos.size(); }
}
