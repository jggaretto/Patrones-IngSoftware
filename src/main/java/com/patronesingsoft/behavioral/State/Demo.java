package com.patronesingsoft.behavioral.State;

/** CLIENTE: las mismas operaciones cambian de comportamiento según el estado. */
public class Demo {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        assert pedido.getEstado().equals("Nuevo");
        boolean anticipado = false;
        try { pedido.enviar(); } catch (IllegalStateException e) { anticipado = true; }
        assert anticipado && pedido.getEstado().equals("Nuevo");
        pedido.pagar();
        assert pedido.getEstado().equals("Pagado");
        boolean pagoRepetido = false;
        try { pedido.pagar(); } catch (IllegalStateException e) { pagoRepetido = true; }
        assert pagoRepetido && pedido.getEstado().equals("Pagado");
        pedido.enviar();
        assert pedido.getEstado().equals("Enviado");
        boolean envioRepetido = false;
        try { pedido.enviar(); } catch (IllegalStateException e) { envioRepetido = true; }
        assert envioRepetido && pedido.getEstado().equals("Enviado");
        boolean pagoFinal = false;
        try { pedido.pagar(); } catch (IllegalStateException e) { pagoFinal = true; }
        assert pagoFinal;
        System.out.println("Estado del pedido: " + pedido.getEstado());
    }
}
