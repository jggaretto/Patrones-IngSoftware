package com.patronesingsoft.Patrones_de_Comportamiento.Strategy;

public class Auto implements Ruta {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("Ruta en AUTO de " + origen + " a " + destino + ": Tomar la autopista principal (Tiempo est. 15 min).");
    }
}
