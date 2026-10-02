package com.patronesingsoft.creational.ObjectPool;

/** CLIENTE: siempre devuelve el préstamo, incluso si falla la operación. */
public class Demo {
    public static void main(String[] args) {
        PoolConexiones pool = new PoolConexiones(1);
        Conexion primera = pool.tomar();
        try {
            System.out.println(primera.consultar());
            boolean agotado = false;
            try { pool.tomar(); } catch (IllegalStateException e) { agotado = true; }
            assert agotado : "No debe crear recursos por encima de la capacidad";
            boolean ajena = false;
            try { pool.devolver(new Conexion(99)); } catch (IllegalArgumentException e) { ajena = true; }
            assert ajena;
        } finally {
            pool.devolver(primera);
        }
        boolean duplicada = false;
        try { pool.devolver(primera); } catch (IllegalArgumentException e) { duplicada = true; }
        assert duplicada;
        Conexion segunda = pool.tomar();
        try {
            assert primera == segunda : "Debe reutilizar el mismo recurso";
            System.out.println("Reutilizada: " + (primera == segunda));
        } finally {
            pool.devolver(segunda);
        }
    }
}
