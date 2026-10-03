package com.patronesingsoft.Patrones_de_Comportamiento.Strategy;

public class Colectivo implements Ruta {
    @Override
    public void calcularRuta(String origen, String destino) {
        System.out.println("Ruta en colectivo " + origen + " a " + destino + ": En la linea E (Tiempo est. 35 min).");
    }
}
