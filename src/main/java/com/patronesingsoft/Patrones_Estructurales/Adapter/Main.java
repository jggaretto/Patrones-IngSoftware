package com.patronesingsoft.Patrones_Estructurales.Adapter;

import java.util.List;

public class Main {

    private static final double MATRICULA = 15000;

    public static void main(String[] args) {

        Cliente ana = new Cliente("Ana Lopez", "ana.lopez@mail.com", "0170099220000012345678");

        System.out.println("=== Caso 1: cobro SIN adaptador (el cliente conoce cada API) ===");
        // El cliente tiene que saber que la pasarela pide centavos y devuelve
        // un String, y que el banco pide pesos enteros y devuelve un codigo.
        PasarelaTarjetaExterna pasarela = new PasarelaTarjetaExterna();
        String estado = pasarela.crearCobro(ana.email(), Math.round(MATRICULA * 100));
        System.out.println("  Resultado tarjeta: " + estado.equals("APROBADO"));

        ServicioTransferenciasBanco banco = new ServicioTransferenciasBanco();
        int codigo = banco.transferir(ana.cbu(), (int) MATRICULA);
        System.out.println("  Resultado banco: " + (codigo == 0));

        System.out.println("\n=== Caso 2: el mismo cobro CON adaptadores (una sola interfaz) ===");
        List<ProcesadorPago> medios = List.of(
                new PagoEfectivo(),
                new AdaptadorTarjeta(new PasarelaTarjetaExterna()),
                new AdaptadorBanco(new ServicioTransferenciasBanco()));

        for (ProcesadorPago medio : medios) {
            cobrarMatricula(medio, ana, MATRICULA);
        }

        System.out.println("\n=== Caso 3: el adaptador tambien traduce el caso de error (monto invalido) ===");
        for (ProcesadorPago medio : medios) {
            cobrarMatricula(medio, ana, 0);
        }
    }

    /**
     * Codigo cliente: solo conoce ProcesadorPago. Funciona igual para el
     * medio propio y para los que vienen de librerias externas.
     */
    private static void cobrarMatricula(ProcesadorPago medio, Cliente cliente, double monto) {
        boolean ok = medio.pagar(cliente, monto);
        System.out.println("  Resultado: " + (ok ? "OK" : "RECHAZADO"));
    }
}
