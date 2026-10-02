package com.patronesingsoft.structural.Adapter;

import java.util.Objects;

/** ADAPTADOR: convierte la interfaz y las unidades sin modificar el sensor. */
public class AdaptadorTemperatura implements MedidorTemperatura {
    private final SensorFahrenheit sensor;

    public AdaptadorTemperatura(SensorFahrenheit sensor) {
        this.sensor = Objects.requireNonNull(sensor);
    }

    @Override
    public double leerCelsius() {
        return (sensor.leerFahrenheit() - 32) * 5.0 / 9.0;
    }
}
