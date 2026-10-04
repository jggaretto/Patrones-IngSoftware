package com.patronesingsoft.Patrones_Estructurales.Facade;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Caso 1: inscripcion SIN fachada (el cliente conoce todo) ===");
        // El cliente debe conocer los 4 subsistemas, su orden y su sincronizacion.
        ServicioAcademico academico = new ServicioAcademico();
        ServicioPagos pagos = new ServicioPagos();
        ServicioBiblioteca biblioteca = new ServicioBiblioteca();
        ServicioNotificaciones notificaciones = new ServicioNotificaciones();

        if (academico.hayCupo("Sistemas")) {
            String legajo = academico.inscribir("Ana Lopez", "Sistemas");
            pagos.generarCuota(legajo, 15000);
            pagos.cobrar(legajo, 15000);
            biblioteca.habilitarPrestamo(legajo);
            notificaciones.enviarBienvenida("Ana Lopez", legajo);
        }

        System.out.println("\n=== Caso 2: la misma inscripcion CON la fachada ===");
        InscripcionFacade facade = new InscripcionFacade();
        ResultadoInscripcion r1 = facade.inscribir("Bruno Fernandez", "Sistemas");
        System.out.println("  Resultado: " + r1);

        System.out.println("\n=== Caso 3: la fachada resuelve el caso de error (sin cupo) ===");
        ResultadoInscripcion r2 = facade.inscribir("Carla Ruiz", "Medicina");
        System.out.println("  Resultado: " + r2);
        System.out.println("  --> Exitoso? " + r2.exitoso());

        System.out.println("\n=== Caso 4: baja coordinada por la fachada ===");
        facade.darDeBaja("Bruno Fernandez", r1.legajo());
    }
}