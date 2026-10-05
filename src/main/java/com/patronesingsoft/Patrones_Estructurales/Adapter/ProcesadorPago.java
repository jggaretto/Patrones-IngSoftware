package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * TARGET (Interfaz objetivo).
 *
 * Es la interfaz que el sistema de la facultad ya conoce y usa para cobrar.
 * El cliente solo habla este "idioma": pagar(cliente, monto) -> true/false.
 */
public interface ProcesadorPago {

    boolean pagar(Cliente cliente, double monto);
}
