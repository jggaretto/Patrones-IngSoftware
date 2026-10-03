package com.patronesingsoft.Patrones_de_Comportamiento.Chain_of_Responsability;

public class SoporteNivel2 extends Soporte {
    @Override
    public void atender(int nivel, String problema) {
        if (nivel == 2) {
            System.out.println("Nivel 2 resolvió: " + problema);
        } else if (siguiente != null) {
            System.out.println("Nivel 2 no puede resolverlo, pasa al Gerente...");
            siguiente.atender(nivel, problema);
        } else {
            System.out.println("Nadie pudo resolver: " + problema);
        }
    }
}
