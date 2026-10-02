package com.patronesingsoft.behavioral.State;

/** ESTADO: define qué acciones admite un pedido en su situación actual. */
public interface EstadoPedido {
    void pagar(Pedido pedido);
    void enviar(Pedido pedido);
    String getNombre();
}
