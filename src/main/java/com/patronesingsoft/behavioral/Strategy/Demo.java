package com.patronesingsoft.behavioral.Strategy;

import java.math.BigDecimal;

/** CLIENTE: conserva el contexto y cambia el algoritmo elegido. */
public class Demo {
    public static void main(String[] args) {
        Cotizador cotizador = new Cotizador(new EnvioEstandar());
        BigDecimal estandar = cotizador.cotizar(3);
        assert estandar.compareTo(new BigDecimal("1600.00")) == 0;
        cotizador.setEstrategia(new EnvioExpress());
        BigDecimal express = cotizador.cotizar(3);
        assert express.compareTo(new BigDecimal("3050.00")) == 0;
        for (EstrategiaEnvio estrategia : new EstrategiaEnvio[] {new EnvioEstandar(), new EnvioExpress()}) {
            for (int peso : new int[] {0, -1}) {
                boolean rechazado = false;
                try { estrategia.calcular(peso); } catch (IllegalArgumentException e) { rechazado = true; }
                assert rechazado : "La estrategia debe validar aunque se invoque directamente";
            }
        }
        boolean nula = false;
        try { cotizador.setEstrategia(null); } catch (NullPointerException e) { nula = true; }
        assert nula;
        System.out.println("Estandar (3 kg): $" + estandar);
        System.out.println("Express (3 kg): $" + express);
    }
}
