package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * Medio de pago PROPIO: ya implementa ProcesadorPago, no necesita adaptador.
 */
public class PagoEfectivo implements ProcesadorPago {

    @Override
    public boolean pagar(Cliente cliente, double monto) {
        System.out.println("  [Efectivo] Cobro de $" + monto + " en caja a " + cliente.nombre());
        return monto > 0;
    }
}
