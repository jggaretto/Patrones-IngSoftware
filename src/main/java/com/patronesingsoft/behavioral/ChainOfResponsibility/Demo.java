package com.patronesingsoft.behavioral.ChainOfResponsibility;

/** CLIENTE: arma la cadena sin acoplar la petición al responsable concreto. */
public class Demo {
    public static void main(String[] args) {
        Soporte cadena = new SoporteBasico(new SoporteEspecializado(null));
        assert cadena.atender(new Solicitud(1)).equals("Atiende soporte basico");
        assert cadena.atender(new Solicitud(2)).equals("Atiende soporte especializado");
        assert cadena.atender(new Solicitud(3)).equals("Sin responsable para ese nivel");
        System.out.println(cadena.atender(new Solicitud(2)));
        System.out.println(cadena.atender(new Solicitud(3)));
    }
}
