package com.patronesingsoft.behavioral.State;

/** ESTADO CONCRETO: el pago habilita el envío y evita un segundo pago. */
public class Pagado implements EstadoPedido {
    public void pagar(Pedido pedido) { throw new IllegalStateException("El pedido ya esta pagado"); }
    public void enviar(Pedido pedido) { pedido.cambiarEstado(new Enviado()); }
    public String getNombre() { return "Pagado"; }
}
