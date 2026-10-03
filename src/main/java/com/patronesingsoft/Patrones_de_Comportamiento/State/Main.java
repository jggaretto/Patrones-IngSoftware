package com.patronesingsoft.Patrones_de_Comportamiento.State;

/** Main propio del patrón State. Demo: muestra el flujo normal, la cancelación y transiciones inválidas. */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Caso 1: flujo normal ===");
        Pedido p1 = new Pedido(1);
        p1.pagar();
        p1.enviar();
        p1.entregar();

        System.out.println("\n=== Caso 2: cancelación antes del envío ===");
        Pedido p2 = new Pedido(2);
        p2.pagar();
        p2.cancelar();

        System.out.println("\n=== Caso 3: transiciones inválidas ===");
        Pedido p3 = new Pedido(3);
        intentar(p3::enviar,   "enviar sin pagar");
        p3.pagar();
        p3.enviar();
        intentar(p3::cancelar, "cancelar un pedido enviado");
        p3.entregar();
        intentar(p3::pagar,    "pagar un pedido entregado");

        System.out.println("\nEstado final del pedido #3: " + p3.getEstadoActual());
    }

    private static void intentar(Runnable accion, String descripcion) {
        try {
            accion.run();
        } catch (IllegalStateException e) {
            System.out.println("  [Error] Intento de " + descripcion + ": " + e.getMessage());
        }
    }
}
