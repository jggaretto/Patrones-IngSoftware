package com.patronesingsoft.behavioral.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** CLIENTE: recorre el agregado usando el contrato estándar Iterator. */
public class Demo {
    public static void main(String[] args) {
        ColeccionLibros libros = new ColeccionLibros(List.of("Patrones", "Java"));
        Iterator<String> primero = libros.iterator();
        Iterator<String> segundo = libros.iterator();
        assert primero.next().equals("Patrones");
        assert primero.next().equals("Java");
        assert segundo.next().equals("Patrones") : "Los cursores deben ser independientes";
        assert !primero.hasNext();
        boolean agotado = false;
        try { primero.next(); } catch (NoSuchElementException e) { agotado = true; }
        assert agotado;
        assert !new ColeccionLibros(List.of()).iterator().hasNext();
        List<String> recorridos = new ArrayList<>();
        for (String libro : libros) recorridos.add(libro);
        assert recorridos.equals(List.of("Patrones", "Java"));
        System.out.println("Libros recorridos: " + recorridos);
    }
}
