package com.patronesingsoft.Patrones_de_Comportamiento.State;

/** ConcreteState: el pedido está en camino; ya no puede cancelarse. */
public class PedidoEnviado implements EstadoPedido {
    @Override public void pagar(Pedido p)    { throw new IllegalStateException("El pedido ya fue pagado."); }
    @Override public void enviar(Pedido p)   { throw new IllegalStateException("El pedido ya fue enviado."); }
    @Override public void entregar(Pedido p) { p.setEstado(new PedidoEntregado()); }
    @Override public void cancelar(Pedido p) { throw new IllegalStateException("No se puede cancelar un pedido ya enviado."); }
    @Override public String getNombre()      { return "ENVIADO"; }
}
