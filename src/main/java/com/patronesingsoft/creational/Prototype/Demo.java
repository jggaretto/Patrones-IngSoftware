package com.patronesingsoft.creational.Prototype;

import java.util.List;

/** CLIENTE: crea una variante de un documento ya configurado. */
public class Demo {
    public static void main(String[] args) {
        Documento original = new Documento("Informe", List.of("software"));
        Documento copia = original.copiar();
        copia.setTitulo("Informe copiado");
        copia.agregarEtiqueta("patrones");
        assert copia != original;
        assert original.getTitulo().equals("Informe");
        assert original.getEtiquetas().equals(List.of("software"));
        assert copia.getEtiquetas().equals(List.of("software", "patrones"));
        System.out.println("Original: " + original.getTitulo() + " " + original.getEtiquetas());
        System.out.println("Copia: " + copia.getTitulo() + " " + copia.getEtiquetas());
    }
}
