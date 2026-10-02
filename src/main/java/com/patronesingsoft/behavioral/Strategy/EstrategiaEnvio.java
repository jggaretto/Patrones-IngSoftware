package com.patronesingsoft.behavioral.Strategy;

import java.math.BigDecimal;

/** ESTRATEGIA: contrato de cálculo de tarifas ficticias. */
public interface EstrategiaEnvio {
    BigDecimal calcular(int pesoKg);

    // Validación compartida por las implementaciones, incluso sin Cotizador.
    static void validarPeso(int pesoKg) {
        if (pesoKg <= 0) throw new IllegalArgumentException("El peso debe ser positivo");
    }
}
