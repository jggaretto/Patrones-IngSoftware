package com.patronesingsoft.structural.Decorator;

/** CLIENTE: selecciona y apila funciones durante la composición. */
public class Demo {
    public static void main(String[] args) {
        Notificador base = new NotificadorCorreo();
        Notificador completo = new ConRegistro(new ConSms(base));
        assert base.enviar("Entrega").equals("Correo: Entrega");
        String resultado = completo.enviar("Entrega");
        assert resultado.equals("Correo: Entrega | SMS: Entrega | Registro: enviado");
        System.out.println(resultado);
    }
}
