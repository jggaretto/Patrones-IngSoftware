package com.patronesingsoft.behavioral.TemplateMethod;

import java.util.List;

/** CLASE ABSTRACTA: fija el orden del algoritmo y deja pasos a las subclases. */
public abstract class ProcesadorInforme {
    public final String generar(List<String> datos) {
        List<String> copia = List.copyOf(datos);
        // El método final impide cambiar la secuencia de estos tres pasos.
        return cabecera() + formatear(copia) + pie();
    }

    protected abstract String cabecera();
    protected abstract String formatear(List<String> datos);

    // HOOK: paso opcional con comportamiento por defecto.
    protected String pie() { return ""; }
}
