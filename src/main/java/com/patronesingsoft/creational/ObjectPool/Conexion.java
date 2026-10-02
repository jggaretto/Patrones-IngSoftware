package com.patronesingsoft.creational.ObjectPool;

/** RECURSO: representa una conexión reutilizable; no abre una conexión real. */
public class Conexion {
    private final int id;

    public Conexion(int id) { this.id = id; }
    public int getId() { return id; }
    public String consultar() { return "Consulta con conexion " + id; }
}
