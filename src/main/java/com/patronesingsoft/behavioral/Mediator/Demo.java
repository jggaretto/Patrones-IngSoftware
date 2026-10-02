package com.patronesingsoft.behavioral.Mediator;

import java.util.List;

/** CLIENTE: registra colegas y demuestra comunicación sin referencias mutuas. */
public class Demo {
    public static void main(String[] args) {
        SalaChat sala = new SalaChat();
        Usuario ana = new Usuario("Ana", sala);
        Usuario luis = new Usuario("Luis", sala);
        sala.registrar(ana);
        sala.registrar(ana);
        sala.registrar(luis);
        ana.enviar("Nos reunimos para el TP");
        assert ana.getRecibidos().isEmpty();
        assert luis.getRecibidos().equals(List.of("Ana: Nos reunimos para el TP"));
        luis.enviar("De acuerdo");
        assert ana.getRecibidos().equals(List.of("Luis: De acuerdo"));
        boolean noRegistrado = false;
        try { new Usuario("Invitado", sala).enviar("Hola"); }
        catch (IllegalArgumentException e) { noRegistrado = true; }
        assert noRegistrado;
        boolean otraSala = false;
        try { sala.registrar(new Usuario("Otra", new SalaChat())); }
        catch (IllegalArgumentException e) { otraSala = true; }
        assert otraSala;
        System.out.println(luis.getRecibidos());
        System.out.println(ana.getRecibidos());
    }
}
