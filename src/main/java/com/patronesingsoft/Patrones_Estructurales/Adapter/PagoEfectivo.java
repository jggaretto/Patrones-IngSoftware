package com.patronesingsoft.Patrones_Estructurales.Adapter;

/** Medio de pago propio: ya cumple la interfaz, no necesita adaptador. */
public class PagoEfectivo implements ProcesadorPago {
    public boolean pagar(double monto) {
        System.out.println("  [Efectivo] Cobrando $" + monto);
        return monto > 0;
    }
}
