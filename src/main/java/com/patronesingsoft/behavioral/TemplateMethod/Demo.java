package com.patronesingsoft.behavioral.TemplateMethod;

import java.util.List;

/** CLIENTE: elige una subclase, pero ambas siguen la misma plantilla. */
public class Demo {
    public static void main(String[] args) {
        List<String> datos = List.of("Patrones", "<Java & UML>");
        ProcesadorInforme texto = new InformeTexto();
        ProcesadorInforme html = new InformeHtml();
        assert texto.generar(datos).equals("INFORME\nPatrones\n<Java & UML>\n");
        assert html.generar(datos).equals("<ul><li>Patrones</li><li>&lt;Java &amp; UML&gt;</li></ul>");
        assert html.generar(List.of()).equals("<ul></ul>");
        assert texto.generar(List.of()).equals("INFORME\n\n");
        System.out.println(texto.generar(datos));
        System.out.println(html.generar(datos));
    }
}
