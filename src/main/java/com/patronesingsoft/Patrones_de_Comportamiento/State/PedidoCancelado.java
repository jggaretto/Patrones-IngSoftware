package com.patronesingsoft.Patrones_de_Comportamiento.State;

/** ConcreteState (final): el pedido fue cancelado; no admite más operaciones. */
public class PedidoCancelado implements EstadoPedido {
    @Override public void pagar(Pedido p)    { throw new IllegalStateException("El pedido está cancelado."); }
    @Override public void enviar(Pedido p)   { throw new IllegalStateException("El pedido está cancelado."); }
    @Override public void entregar(Pedido p) { throw new IllegalStateException("El pedido está cancelado."); }
    @Override public void cancelar(Pedido p) { throw new IllegalStateException("El pedido ya está cancelado."); }
    @Override public String getNombre()      { return "CANCELADO"; }
}
