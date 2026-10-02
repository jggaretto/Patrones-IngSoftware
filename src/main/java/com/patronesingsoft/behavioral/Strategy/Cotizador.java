package com.patronesingsoft.behavioral.Strategy;

import java.math.BigDecimal;
import java.util.Objects;

/** CONTEXTO: delega en una estrategia intercambiable durante la ejecución. */
public class Cotizador {
    private EstrategiaEnvio estrategia;

    public Cotizador(EstrategiaEnvio estrategia) { this.estrategia = Objects.requireNonNull(estrategia); }
    public void setEstrategia(EstrategiaEnvio estrategia) { this.estrategia = Objects.requireNonNull(estrategia); }

    public BigDecimal cotizar(int pesoKg) {
        EstrategiaEnvio.validarPeso(pesoKg);
        return estrategia.calcular(pesoKg);
    }
}
