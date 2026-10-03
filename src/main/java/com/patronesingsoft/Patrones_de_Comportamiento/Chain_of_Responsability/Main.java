package com.patronesingsoft.Patrones_de_Comportamiento.Chain_of_Responsability;

public class Main {
    public static void main(String[] args) {
        // 1. Crear los eslabones
        Soporte nivel1 = new SoporteNivel1();
        Soporte nivel2 = new SoporteNivel2();
        Soporte gerente = new SoporteGerente();

        // 2. Armar la cadena: Nivel 1 -> Nivel 2 -> Gerente
        nivel1.setSiguiente(nivel2).setSiguiente(gerente);

        // 3. El cliente siempre habla con el primer eslabón
        System.out.println("--- Caso 1: consulta simple (nivel 1) ---");
        nivel1.atender(1, "Olvidé mi contraseña");

        System.out.println("\n--- Caso 2: falla técnica (nivel 2) ---");
        nivel1.atender(2, "No funciona el sistema de facturación");

        System.out.println("\n--- Caso 3: reclamo grave (nivel 3) ---");
        nivel1.atender(3, "Fraude con mi tarjeta de crédito");
    }
}
