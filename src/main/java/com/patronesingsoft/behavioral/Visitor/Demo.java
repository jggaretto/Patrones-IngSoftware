package com.patronesingsoft.behavioral.Visitor;

import java.util.List;

/** CLIENTE: aplica visitantes diferentes sobre la misma estructura de elementos. */
public class Demo {
    public static void main(String[] args) {
        List<Elemento> elementos = List.of(new Documento(3), new Imagen(120));
        Visitante descripcion = new DescripcionVisitante();
        Visitante etiqueta = new EtiquetaVisitante();
        assert elementos.get(0).aceptar(descripcion).equals("Documento: 3 paginas");
        assert elementos.get(1).aceptar(descripcion).equals("Imagen: 120 KB");
        assert elementos.get(0).aceptar(etiqueta).equals("DOC[3]");
        assert elementos.get(1).aceptar(etiqueta).equals("IMG[120]");
        for (Elemento elemento : elementos) {
            System.out.println(elemento.aceptar(descripcion) + " -> " + elemento.aceptar(etiqueta));
        }
    }
}
