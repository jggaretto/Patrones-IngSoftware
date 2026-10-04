package com.patronesingsoft.Patrones_Creacionales.Prototype;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * PROTOTYPE MANAGER (registro de prototipos).
 *
 * Guarda una instancia "modelo" de cada tipo de documento y, cuando alguien
 * pide uno nuevo, no lo construye desde cero: se limita a clonar el modelo.
 * Asi el cliente pide "un curriculum" sin conocer su estructura interna.
 */
public class RegistroPrototipos {

    public enum Tipo {
        CURRICULUM, CARTA, INFORME
    }

    private final Map<Tipo, Documento> prototipos = new EnumMap<>(Tipo.class);

    public RegistroPrototipos() {
        // Se registra un unico prototipo por tipo, cargado con contenido
        // base que todos los documentos de ese tipo comparten.
        prototipos.put(Tipo.CURRICULUM,
                new Curriculum("Curriculum", "Formacion academica y experiencia laboral.", List.of("cv", "rrhh")));
        prototipos.put(Tipo.CARTA,
                new CartaPresentacion("Carta", "Presentacion personal y solicitud de empleo.", List.of("carta", "rrhh")));
        prototipos.put(Tipo.INFORME,
                new Informe("Informe", "Detalle de tareas realizadas en el periodo.", List.of("informe", "calidad")));
    }

    /**
     * Devuelve una NUEVA instancia creada a partir del prototipo registrado.
     */
    public Documento crear(Tipo tipo) {
        Documento prototipo = prototipos.get(tipo);
        if (prototipo == null) {
            throw new IllegalArgumentException("No hay prototipo registrado para: " + tipo);
        }
        return prototipo.clonarProfundo();
    }

    public List<Tipo> tiposDisponibles() {
        return new ArrayList<>(prototipos.keySet());
    }
}