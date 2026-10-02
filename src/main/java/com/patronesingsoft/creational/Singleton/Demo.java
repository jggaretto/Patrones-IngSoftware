package com.patronesingsoft.creational.Singleton;

/** CLIENTE: dos consultas reciben exactamente el mismo objeto. */
public class Demo {
    public static void main(String[] args) {
        Configuracion primera = Configuracion.getInstancia();
        Configuracion segunda = Configuracion.getInstancia();
        assert primera == segunda : "Debe existir una sola instancia";
        assert primera.getNombreAplicacion().equals("Campus virtual");
        System.out.println("Aplicacion: " + primera.getNombreAplicacion());
        System.out.println("Misma instancia: " + (primera == segunda));
    }
}
