package com.patronesingsoft.behavioral.Strategy;

import java.math.BigDecimal;

/** ESTRATEGIA CONCRETA: otra tarifa para el mismo contrato. */
public class EnvioExpress implements EstrategiaEnvio {
    public BigDecimal calcular(int pesoKg) {
        EstrategiaEnvio.validarPeso(pesoKg);
        return new BigDecimal("2000.00")
                .add(new BigDecimal("350.00").multiply(BigDecimal.valueOf(pesoKg)));
    }
}
