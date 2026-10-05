package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * ADAPTER para el servicio de transferencias del banco.
 *  - Cliente        -> CBU
 *  - monto double   -> pesos enteros
 *  - codigo 0/otro  -> boolean
 */
public class AdaptadorBanco implements ProcesadorPago {

    private final ServicioTransferenciasBanco banco;

    public AdaptadorBanco(ServicioTransferenciasBanco banco) {
        this.banco = banco;
    }

    @Override
    public boolean pagar(Cliente cliente, double monto) {
        int codigo = banco.transferir(cliente.cbu(), (int) Math.round(monto));
        return codigo == 0;
    }
}
