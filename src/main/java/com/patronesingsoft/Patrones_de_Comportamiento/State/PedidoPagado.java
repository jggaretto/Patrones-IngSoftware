package com.patronesingsoft.Patrones_de_Comportamiento.State;

/** ConcreteState: el pedido está pagado y listo para despacho. */
public class PedidoPagado implements EstadoPedido {
    @Override public void pagar(Pedido p)    { throw new IllegalStateException("El pedido ya fue pagado."); }
    @Override public void enviar(Pedido p)   { p.setEstado(new PedidoEnviado()); }
    @Override public void entregar(Pedido p) { throw new IllegalStateException("El pedido todavía no fue enviado."); }
    @Override public void cancelar(Pedido p) { p.setEstado(new PedidoCancelado()); } // (se reintegra el pago)
    @Override public String getNombre()      { return "PAGADO"; }
}
