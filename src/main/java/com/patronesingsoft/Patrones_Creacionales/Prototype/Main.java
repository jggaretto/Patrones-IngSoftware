package com.patronesingsoft.Patrones_Creacionales.Prototype;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Caso 1: clonar un prototipo base ===");

        Curriculum modelo = new Curriculum(
                "Curriculum",
                "Formacion academica y experiencia laboral.",
                List.of("cv", "rrhh"));

        System.out.println("  Original : " + modelo);

        Documento copia = modelo.clonar();
        System.out.println("  Copia    : " + copia);

        System.out.println("  --> Son el mismo objeto?     " + (modelo == copia));
        System.out.println("  --> Comparten la lista?      " + (modelo.getEtiquetas() == copia.getEtiquetas()));

        System.out.println("\n=== Caso 2: modificar la copia no afecta al original (copia profunda) ===");

        Curriculum copiaProfunda = modelo.clonarProfundo();
        System.out.println("  Copia profunda inicial : " + copiaProfunda);

        copiaProfunda.setTitulo("Curriculum de Juan Perez");
        copiaProfunda.getEtiquetas().add("urgente");
        copiaProfunda.setContenido("Actualizado por el_area de RRHH.");

        System.out.println("  Copia modificada        : " + copiaProfunda);
        System.out.println("  Original intacto        : " + modelo);

        System.out.println("\n=== Caso 3: el peligro de la copia superficial ===");

        Documento copiaSuperficial = modelo.clonar();
        copiaSuperficial.getEtiquetas().add("URGENTE-VERIFICAR");

        System.out.println("  Original tras tocar la copia superficial: " + modelo);
        System.out.println("  --> Se modifico el original? " + modelo.getEtiquetas().contains("URGENTE-VERIFICAR"));

        System.out.println("\n=== Caso 4: el registro de prototipos crea documentos sin 'new' ===");

        RegistroPrototipos registro = new RegistroPrototipos();
        System.out.println("  Tipos registrados: " + registro.tiposDisponibles());

        Documento cv = registro.crear(RegistroPrototipos.Tipo.CURRICULUM);
        cv.personalized("Maria Gomez");
        System.out.println("  Nuevo curriculum: " + cv);

        Documento carta = registro.crear(RegistroPrototipos.Tipo.CARTA);
        carta.personalized("Martin Diaz");
        System.out.println("  Nueva carta    : " + carta);

        System.out.println("\n=== Caso 5: polymorphism: el cliente no conoce la clase concreta ===");

        List<Documento> documentos = List.of(
                registro.crear(RegistroPrototipos.Tipo.CURRICULUM),
                registro.crear(RegistroPrototipos.Tipo.CARTA),
                registro.crear(RegistroPrototipos.Tipo.INFORME));

        for (Documento d : documentos) {
            d.personalized("Equipo de Ventas");
            d.getEtiquetas().add("2026");
            System.out.println("  " + d);
        }
    }
}