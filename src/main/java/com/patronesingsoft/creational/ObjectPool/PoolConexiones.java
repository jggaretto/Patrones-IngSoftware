package com.patronesingsoft.creational.ObjectPool;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/** POOL: presta recursos existentes y controla su devolución. */
public class PoolConexiones {
    private final Queue<Conexion> disponibles = new ArrayDeque<>();
    private final Set<Conexion> prestadas = new HashSet<>();

    public PoolConexiones(int capacidad) {
        if (capacidad <= 0) throw new IllegalArgumentException("Capacidad positiva requerida");
        for (int i = 1; i <= capacidad; i++) disponibles.add(new Conexion(i));
    }

    // ponytail: pool de un hilo y sin espera; usar un pool especializado para concurrencia real.
    public Conexion tomar() {
        Conexion conexion = disponibles.poll();
        if (conexion == null) throw new IllegalStateException("Pool agotado");
        prestadas.add(conexion);
        return conexion;
    }

    public void devolver(Conexion conexion) {
        // Evita devolver recursos ajenos o liberar dos veces la misma conexión.
        if (!prestadas.remove(conexion)) {
            throw new IllegalArgumentException("La conexion no estaba prestada por este pool");
        }
        disponibles.add(conexion);
    }
}
