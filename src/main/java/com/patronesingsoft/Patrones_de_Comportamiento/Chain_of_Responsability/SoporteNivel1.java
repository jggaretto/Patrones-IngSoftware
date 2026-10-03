package com.patronesingsoft.Patrones_de_Comportamiento.Chain_of_Responsability;

public class SoporteNivel1 extends Soporte {
    @Override
    public void atender(int nivel, String problema) {
        if (nivel == 1) {
            System.out.println("Nivel 1 resolvió: " + problema);
        } else if (siguiente != null) {
            System.out.println("Nivel 1 no puede resolverlo, pasa al Nivel 2...");
            siguiente.atender(nivel, problema);
        } else {
            System.out.println("Nadie pudo resolver: " + problema);
        }
    }
}
