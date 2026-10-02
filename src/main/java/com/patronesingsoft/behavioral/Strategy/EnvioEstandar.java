package com.patronesingsoft.behavioral.Strategy;

import java.math.BigDecimal;

/** ESTRATEGIA CONCRETA: tarifa base más importe por kilogramo. */
public class EnvioEstandar implements EstrategiaEnvio {
    public BigDecimal calcular(int pesoKg) {
        EstrategiaEnvio.validarPeso(pesoKg);
        return new BigDecimal("1000.00")
                .add(new BigDecimal("200.00").multiply(BigDecimal.valueOf(pesoKg)));
    }
}
