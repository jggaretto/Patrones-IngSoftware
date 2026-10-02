package com.patronesingsoft.structural.Facade;

/** SUBSISTEMA: procesa un cobro ficticio, expresado en centavos. */
public class Pago {
    public String cobrar(int centavos) {
        if (centavos <= 0) throw new IllegalArgumentException("Importe positivo requerido");
        return "Pago aprobado: " + centavos + " centavos";
    }
}
