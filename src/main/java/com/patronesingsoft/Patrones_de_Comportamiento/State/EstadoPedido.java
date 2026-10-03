package com.patronesingsoft.Patrones_de_Comportamiento.State;

/**
 * State (interfaz): define las operaciones que dependen del estado del pedido.
 * Cada estado concreto decide si la operación es válida y a qué estado pasa.
 */
public interface EstadoPedido {
    void pagar(Pedido pedido);
    void enviar(Pedido pedido);
    void entregar(Pedido pedido);
    void cancelar(Pedido pedido);
    String getNombre();
}
