package com.patronesingsoft.Patrones_Estructurales.Adapter;

/** TARGET: la interfaz que el sistema ya conoce para cobrar. */
public interface ProcesadorPago {
    boolean pagar(double monto);
}
