package com.patronesingsoft.behavioral.State;

/** ESTADO CONCRETO: un pedido nuevo puede pagarse, pero todavía no enviarse. */
public class Nuevo implements EstadoPedido {
    public void pagar(Pedido pedido) { pedido.cambiarEstado(new Pagado()); }
    public void enviar(Pedido pedido) { throw new IllegalStateException("Pagar antes de enviar"); }
    public String getNombre() { return "Nuevo"; }
}
