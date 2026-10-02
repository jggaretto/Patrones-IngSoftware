package com.patronesingsoft.behavioral.TemplateMethod;

import java.util.List;

/** CLASE CONCRETA: completa los pasos para un informe de texto. */
public class InformeTexto extends ProcesadorInforme {
    protected String cabecera() { return "INFORME\n"; }
    protected String formatear(List<String> datos) { return String.join("\n", datos) + "\n"; }
}
