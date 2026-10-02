package com.patronesingsoft.behavioral.TemplateMethod;

import java.util.List;

/** CLASE CONCRETA: usa el mismo algoritmo para un fragmento HTML. */
public class InformeHtml extends ProcesadorInforme {
    protected String cabecera() { return "<ul>"; }

    protected String formatear(List<String> datos) {
        StringBuilder resultado = new StringBuilder();
        for (String dato : datos) {
            // Escapa texto antes de insertarlo dentro de elementos HTML.
            String seguro = dato.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
            resultado.append("<li>").append(seguro).append("</li>");
        }
        return resultado.toString();
    }

    protected String pie() { return "</ul>"; }
}
