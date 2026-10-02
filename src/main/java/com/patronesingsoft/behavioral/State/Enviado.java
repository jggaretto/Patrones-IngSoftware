package com.patronesingsoft.behavioral.State;

/** ESTADO CONCRETO: estado final del flujo de ejemplo. */
public class Enviado implements EstadoPedido {
    public void pagar(Pedido pedido) { throw new IllegalStateException("Pedido ya enviado"); }
    public void enviar(Pedido pedido) { throw new IllegalStateException("El pedido ya fue enviado"); }
    public String getNombre() { return "Enviado"; }
}
