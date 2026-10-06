package com.patronesingsoft.Patrones_Estructurales.Adapter;

/** ADAPTER: cumple ProcesadorPago y por dentro traduce a la API de la pasarela. */
public class AdaptadorPasarela implements ProcesadorPago {
    private final PasarelaExterna pasarela;

    public AdaptadorPasarela(PasarelaExterna pasarela) { this.pasarela = pasarela; }

    public boolean pagar(double monto) {
        String estado = pasarela.cobrarEnCentavos(Math.round(monto * 100)); // pesos -> centavos
        return estado.equals("APROBADO");                                   // texto -> boolean
    }
}
