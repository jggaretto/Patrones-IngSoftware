package com.patronesingsoft.structural.Bridge;

/** CLIENTE: combina dos clases de controles con dos implementaciones. */
public class Demo {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Televisor televisor = new Televisor();
        ControlRemoto basico = new ControlRemoto(radio);
        ControlAvanzado avanzado = new ControlAvanzado(televisor);
        basico.alternarEncendido();
        basico.ajustarVolumen(30);
        avanzado.alternarEncendido();
        avanzado.ajustarVolumen(80);
        avanzado.silenciar();
        assert radio.estaEncendido() && radio.getVolumen() == 30;
        assert televisor.estaEncendido() && televisor.getVolumen() == 0;
        basico.alternarEncendido();
        assert !radio.estaEncendido() && televisor.estaEncendido();
        new ControlAvanzado(radio).silenciar();
        new ControlRemoto(televisor).ajustarVolumen(25);
        assert radio.getVolumen() == 0 && televisor.getVolumen() == 25;
        System.out.println("Bridge: controles y dispositivos combinados independientemente.");
    }
}
