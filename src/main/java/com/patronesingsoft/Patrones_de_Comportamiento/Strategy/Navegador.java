package com.patronesingsoft.Patrones_de_Comportamiento.Strategy;

public class Navegador {
    private Ruta estrategia;

    // Permite configurar o cambiar la forma de viaje
    public void setEstrategia(Ruta estrategia) {
        this.estrategia = estrategia;
    }

    public void iniciarViaje(String origen, String destino) {
        if (estrategia == null) {
            System.out.println("Por favor, selecciona un medio de transporte primero.");
            return;
        }
        // Ejecuta el cálculo de ruta de la estrategia seleccionada
        estrategia.calcularRuta(origen, destino);
    }
}
