package com.patronesingsoft.Patrones_Estructurales.Adapter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sin adaptador: el cliente traduce a mano ===");
        PasarelaExterna pasarela = new PasarelaExterna();
        String estado = pasarela.cobrarEnCentavos(Math.round(15000.0 * 100));
        System.out.println("  Resultado: " + estado);

        System.out.println("\n=== Con adaptador: todos se usan igual ===");
        List<ProcesadorPago> medios = List.of(
                new PagoEfectivo(),
                new AdaptadorPasarela(new PasarelaExterna()));

        for (ProcesadorPago medio : medios) {
            boolean ok = medio.pagar(15000);
            System.out.println("  Resultado: " + (ok ? "OK" : "RECHAZADO"));
        }
    }
}
