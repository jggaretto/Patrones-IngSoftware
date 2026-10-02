package com.patronesingsoft.structural.Composite;

/** CLIENTE: trata archivos y carpetas mediante ElementoArchivo. */
public class Demo {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta();
        Carpeta apuntes = new Carpeta();
        assert raiz.getTamanio() == 0;
        apuntes.agregar(new Archivo(20));
        apuntes.agregar(new Archivo(30));
        raiz.agregar(new Archivo(10));
        raiz.agregar(apuntes);
        assert apuntes.getTamanio() == 50;
        assert raiz.getTamanio() == 60;
        boolean ciclo = false;
        try { apuntes.agregar(raiz); } catch (IllegalArgumentException e) { ciclo = true; }
        assert ciclo && raiz.getTamanio() == 60;
        System.out.println("Tamanio total: " + raiz.getTamanio());
    }
}
