package com.patronesingsoft.creational.DependencyInjection;

/** COMPOSICIÓN: conecta el servicio con una dependencia elegida por el cliente. */
public class Demo {
    public static void main(String[] args) {
        ServicioInscripcion correo = new ServicioInscripcion(new Correo());
        ServicioInscripcion sms = new ServicioInscripcion(new Sms());
        assert correo.inscribir("Ana").equals("Correo de inscripcion para Ana");
        assert sms.inscribir("Ana").equals("SMS de inscripcion para Ana");
        // Una dependencia de prueba también se puede inyectar sin frameworks.
        ServicioInscripcion prueba = new ServicioInscripcion(alumno -> "Prueba: " + alumno);
        assert prueba.inscribir("Luis").equals("Prueba: Luis");
        boolean rechazado = false;
        try { correo.inscribir(" "); } catch (IllegalArgumentException e) { rechazado = true; }
        assert rechazado : "El servicio debe rechazar un alumno sin nombre";
        System.out.println(correo.inscribir("Ana"));
        System.out.println(sms.inscribir("Ana"));
    }
}
