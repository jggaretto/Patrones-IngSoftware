package com.patronesingsoft.Patrones_Estructurales.Facade;

/**
 * Subsistema academico. Gestiona cupos y legajos.
 *
 * Es una pieza independiente del resto: sabe inscribir, pero no sabe nada de
 * pagos, biblioteca ni notificaciones.
 */
public class ServicioAcademico {

    private int legajoActual = 1000;

    public boolean hayCupo(String carrera) {
        System.out.println("  [Academico] Verificando cupo para " + carrera + "...");
        return !carrera.equalsIgnoreCase("Medicina");
    }

    public String inscribir(String alumno, String carrera) {
        String legajo = "L-" + (++legajoActual);
        System.out.println("  [Academico] Inscrito " + alumno + " en " + carrera + " -> " + legajo);
        return legajo;
    }

    public void darDeBaja(String legajo) {
        System.out.println("  [Academico] Baja academica registrada para " + legajo);
    }
}