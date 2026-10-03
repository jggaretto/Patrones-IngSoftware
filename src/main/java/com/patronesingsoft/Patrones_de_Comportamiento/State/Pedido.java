package com.patronesingsoft.Patrones_de_Comportamiento.State;

/**
 * Context: el objeto cuyo comportamiento cambia según su estado.
 * No tiene if/switch sobre el estado: delega todo en el estado actual.
 */
public class Pedido {

    private final int id;
    private EstadoPedido estado;

    public Pedido(int id) {
        this.id = id;
        this.estado = new PedidoNuevo(); // estado inicial
    }

    // Operaciones públicas: se delegan al estado actual
    public void pagar()    { estado.pagar(this); }
    public void enviar()   { estado.enviar(this); }
    public void entregar() { estado.entregar(this); }
    public void cancelar() { estado.cancelar(this); }

    /** Lo usan los estados concretos para realizar la transición. */
    void setEstado(EstadoPedido nuevo) {
        System.out.println("  Pedido #" + id + ": " + estado.getNombre() + " -> " + nuevo.getNombre());
        this.estado = nuevo;
    }

    public String getEstadoActual() { return estado.getNombre(); }
    public int getId() { return id; }
}
