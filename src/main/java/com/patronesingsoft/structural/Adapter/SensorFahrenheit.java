package com.patronesingsoft.structural.Adapter;

/** ADAPTADO: componente existente con una interfaz incompatible. */
public class SensorFahrenheit {
    private final double grados;

    public SensorFahrenheit(double grados) {
        if (!Double.isFinite(grados)) throw new IllegalArgumentException("Temperatura finita requerida");
        this.grados = grados;
    }

    public double leerFahrenheit() { return grados; }
}
