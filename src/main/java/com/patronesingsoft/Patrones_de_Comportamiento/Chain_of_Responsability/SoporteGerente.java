package com.patronesingsoft.Patrones_de_Comportamiento.Chain_of_Responsability;

public class SoporteGerente extends Soporte {
    @Override
    public void atender(int nivel, String problema) {
        if (nivel == 3) {
            System.out.println("Gerente resolvió: " + problema);
        } else if (siguiente != null) {
            siguiente.atender(nivel, problema);
        } else {
            System.out.println("Nadie pudo resolver: " + problema);
        }
    }
}
