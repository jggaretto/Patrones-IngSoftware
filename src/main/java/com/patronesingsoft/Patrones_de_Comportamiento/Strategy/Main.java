package com.patronesingsoft.Patrones_de_Comportamiento.Strategy;

public class Main {
    public static void main(String[] args) {
        Navegador gps = new Navegador();
        
        String origen = "Mi Casa";
        String destino = "Unvime";

        // 1. El usuario elige ir en auto
        gps.setEstrategia(new Auto());
        gps.iniciarViaje(origen, destino);

        System.out.println("--- Cambiando de opinión ---");

        // 2. El usuario cambia de opinión y decide ir caminando
        gps.setEstrategia(new Colectivo());
        gps.iniciarViaje(origen, destino);
    }
}