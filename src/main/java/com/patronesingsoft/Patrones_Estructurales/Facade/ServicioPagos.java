package com.patronesingsoft.Patrones_Estructurales.Facade;

/**
 * Subsistema de pagos.
 */
public class ServicioPagos {

    public void generarCuota(String legajo, double monto) {
        System.out.println("  [Pagos] Cuota generada para " + legajo + " por $" + monto);
    }

    public boolean cobrar(String legajo, double monto) {
        System.out.println("  [Pagos] Cobro de $" + monto + " registrado para " + legajo);
        return monto > 0;
    }

    public void reembolsar(String legajo) {
        System.out.println("  [Pagos] Reembolso emitido para " + legajo);
    }
}