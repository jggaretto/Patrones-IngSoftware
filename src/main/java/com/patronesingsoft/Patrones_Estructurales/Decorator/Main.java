package com.patronesingsoft.Patrones_Estructurales.Decorator;

public class Main {

    public static void main(String[] args) {

        String aviso = "Se abrio la inscripcion a examenes";

        System.out.println("=== Caso 1: notificador base (solo email) ===");
        Notificador base = new NotificadorEmail();
        avisar(base, aviso);

        System.out.println("\n=== Caso 2: email + SMS ===");
        // Se envuelve el objeto base; la clase NotificadorEmail no se toca.
        Notificador conSms = new DecoradorSMS(new NotificadorEmail());
        avisar(conSms, aviso);

        System.out.println("\n=== Caso 3: email + SMS + WhatsApp (decoradores apilados) ===");
        Notificador completo = new DecoradorWhatsapp(new DecoradorSMS(new NotificadorEmail()));
        avisar(completo, aviso);

        System.out.println("\n=== Caso 4a: el ORDEN importa -> SMS por fuera, Urgente por dentro ===");
        // El SMS recibe el mensaje original; solo el email llega marcado como urgente.
        Notificador ordenA = new DecoradorSMS(new DecoradorUrgente(new NotificadorEmail()));
        avisar(ordenA, "Examen reprogramado");

        System.out.println("\n=== Caso 4b: el ORDEN importa -> Urgente por fuera, SMS por dentro ===");
        // Ahora el mensaje se transforma primero y TODOS los canales lo reciben urgente.
        Notificador ordenB = new DecoradorUrgente(new DecoradorSMS(new NotificadorEmail()));
        avisar(ordenB, "Examen reprogramado");
    }

    /**
     * El cliente solo depende de la interfaz Notificador: no sabe (ni le
     * importa) cuantos decoradores tiene por debajo.
     */
    private static void avisar(Notificador notificador, String mensaje) {
        notificador.enviar(mensaje);
    }
}
