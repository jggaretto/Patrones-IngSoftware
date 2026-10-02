package com.patronesingsoft.structural.Adapter;

/** CLIENTE: solo utiliza el contrato esperado en Celsius. */
public class Demo {
    public static void main(String[] args) {
        MedidorTemperatura medidor = new AdaptadorTemperatura(new SensorFahrenheit(68));
        assert Math.abs(medidor.leerCelsius() - 20) < 0.000001;
        assert new AdaptadorTemperatura(new SensorFahrenheit(32)).leerCelsius() == 0;
        System.out.println("Temperatura Celsius: " + medidor.leerCelsius());
    }
}
