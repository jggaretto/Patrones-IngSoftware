package com.patronesingsoft.structural.Facade;

import java.util.Objects;

/** FACHADA: ofrece una operación de alto nivel sobre tres subsistemas. */
public class TiendaFacade {
    private final Inventario inventario;
    private final Pago pago;
    private final Envio envio;

    public TiendaFacade(Inventario inventario, Pago pago, Envio envio) {
        this.inventario = Objects.requireNonNull(inventario);
        this.pago = Objects.requireNonNull(pago);
        this.envio = Objects.requireNonNull(envio);
    }

    public String comprar(String producto, int centavos) {
        if (producto == null || producto.isBlank() || centavos <= 0) {
            throw new IllegalArgumentException("Producto e importe positivo requeridos");
        }
        if (!inventario.disponible(producto)) throw new IllegalStateException("Sin stock");
        return pago.cobrar(centavos) + " | " + envio.preparar(producto);
    }
}
