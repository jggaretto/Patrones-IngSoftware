package com.patronesingsoft.Patrones_de_Comportamiento.State;

/** ConcreteState (final): el pedido fue entregado; no admite más operaciones. */
public class PedidoEntregado implements EstadoPedido {
    @Override public void pagar(Pedido p)    { throw new IllegalStateException("El pedido ya fue entregado."); }
    @Override public void enviar(Pedido p)   { throw new IllegalStateException("El pedido ya fue entregado."); }
    @Override public void entregar(Pedido p) { throw new IllegalStateException("El pedido ya fue entregado."); }
    @Override public void cancelar(Pedido p) { throw new IllegalStateException("No se puede cancelar un pedido entregado."); }
    @Override public String getNombre()      { return "ENTREGADO"; }
}
