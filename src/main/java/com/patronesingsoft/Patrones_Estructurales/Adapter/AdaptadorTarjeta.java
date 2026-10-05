package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * ADAPTER (Adaptador de objeto, por composicion).
 *
 * Implementa la interfaz que espera el cliente (ProcesadorPago) y por dentro
 * traduce cada llamada a la API de la pasarela:
 *  - Cliente           -> email
 *  - monto en pesos    -> centavos
 *  - "APROBADO"/otros  -> boolean
 */
public class AdaptadorTarjeta implements ProcesadorPago {

    private final PasarelaTarjetaExterna pasarela;

    public AdaptadorTarjeta(PasarelaTarjetaExterna pasarela) {
        this.pasarela = pasarela;
    }

    @Override
    public boolean pagar(Cliente cliente, double monto) {
        long centavos = Math.round(monto * 100);
        String estado = pasarela.crearCobro(cliente.email(), centavos);
        return "APROBADO".equals(estado);
    }
}
