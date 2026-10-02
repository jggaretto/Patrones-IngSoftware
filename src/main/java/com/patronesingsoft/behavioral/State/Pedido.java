package com.patronesingsoft.behavioral.State;

import java.util.Objects;

/** CONTEXTO: delega operaciones en su estado actual. */
public class Pedido {
    private EstadoPedido estado = new Nuevo();
    public void pagar() { estado.pagar(this); }
    public void enviar() { estado.enviar(this); }
    public String getEstado() { return estado.getNombre(); }
    void cambiarEstado(EstadoPedido estado) { this.estado = Objects.requireNonNull(estado); }
}
