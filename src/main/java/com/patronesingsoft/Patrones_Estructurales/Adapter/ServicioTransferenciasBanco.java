package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * ADAPTEE 2 (otra clase existente con interfaz incompatible).
 *
 * Simula el servicio de transferencias de un banco: pide el CBU, el monto en
 * pesos ENTEROS (int) y devuelve un codigo numerico (0 = OK, otro = error).
 */
public class ServicioTransferenciasBanco {

    public int transferir(String cbuOrigen, int pesos) {
        System.out.println("  [Banco] Transferencia de $" + pesos + " desde CBU " + cbuOrigen);
        return pesos > 0 ? 0 : 1;
    }
}
