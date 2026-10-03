package com.patronesingsoft.Patrones_de_Comportamiento.State;

/** ConcreteState: el pedido fue creado pero todavía no se pagó. */
public class PedidoNuevo implements EstadoPedido {
    @Override public void pagar(Pedido p)    { p.setEstado(new PedidoPagado()); }
    @Override public void enviar(Pedido p)   { throw new IllegalStateException("No se puede enviar un pedido sin pagar."); }
    @Override public void entregar(Pedido p) { throw new IllegalStateException("No se puede entregar un pedido sin pagar."); }
    @Override public void cancelar(Pedido p) { p.setEstado(new PedidoCancelado()); }
    @Override public String getNombre()      { return "NUEVO"; }
}
