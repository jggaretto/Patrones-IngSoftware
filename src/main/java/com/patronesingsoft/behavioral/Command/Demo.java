package com.patronesingsoft.behavioral.Command;

/** CLIENTE: vincula receptor, comandos e invocador. */
public class Demo {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Control control = new Control();
        assert !control.deshacer();
        EncenderComando primero = new EncenderComando(luz);
        control.ejecutar(primero);
        assert luz.estaEncendida();
        boolean repetido = false;
        try { control.ejecutar(primero); } catch (IllegalStateException e) { repetido = true; }
        assert repetido;
        control.ejecutar(new EncenderComando(luz));
        boolean deshizoSegundo = control.deshacer();
        assert deshizoSegundo && luz.estaEncendida() : "Restaura el estado previo del segundo comando";
        boolean deshizoPrimero = control.deshacer();
        assert deshizoPrimero && !luz.estaEncendida();
        assert !control.deshacer();
        System.out.println("Command: historial y estado anterior restaurados.");
    }
}
