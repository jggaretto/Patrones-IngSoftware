package com.patronesingsoft.Patrones_Estructurales.Facade;

/**
 * FACADE (Fachada).
 *
 * Ofrece una interfaz unica y sencilla para el conjunto de subsistemas.
 * El cliente hace UNA llamada y la fachada se encarga de coordinar el orden
 * correcto: verificar cupo -> inscribir -> cobrar -> habilitar biblioteca ->
 * notificar.
 *
 * La fachada NO reemplaza a los subsistemas: quien necesite usar uno solo
 * puede seguir accediendo a el directamente.
 */
public class InscripcionFacade {

    private final ServicioAcademico academico;
    private final ServicioPagos pagos;
    private final ServicioBiblioteca biblioteca;
    private final ServicioNotificaciones notificaciones;

    private static final double MATRICULA = 15000;

    public InscripcionFacade() {
        this.academico = new ServicioAcademico();
        this.pagos = new ServicioPagos();
        this.biblioteca = new ServicioBiblioteca();
        this.notificaciones = new ServicioNotificaciones();
    }

    /**
     * Inscribe a un alumno en una carrera coordinando todos los subsistemas.
     */
    public ResultadoInscripcion inscribir(String alumno, String carrera) {
        System.out.println("== Inscripcion de " + alumno + " en " + carrera + " ==");

        if (!academico.hayCupo(carrera)) {
            return new ResultadoInscripcion(false, null,
                    "Sin cupo en " + carrera + ". Inscripcion rechazada.");
        }

        String legajo = academico.inscribir(alumno, carrera);
        pagos.generarCuota(legajo, MATRICULA);
        pagos.cobrar(legajo, MATRICULA);
        biblioteca.habilitarPrestamo(legajo);
        notificaciones.enviarBienvenida(alumno, legajo);

        return new ResultadoInscripcion(true, legajo, "Inscripcion completada correctamente.");
    }

    /**
     * Da de baja al alumno coordinando los mismos subsistemas en sentido inverso.
     */
    public void darDeBaja(String alumno, String legajo) {
        System.out.println("== Baja de " + alumno + " (" + legajo + ") ==");
        academico.darDeBaja(legajo);
        pagos.reembolsar(legajo);
        biblioteca.revocarPrestamo(legajo);
        notificaciones.enviarBaja(alumno);
    }
}