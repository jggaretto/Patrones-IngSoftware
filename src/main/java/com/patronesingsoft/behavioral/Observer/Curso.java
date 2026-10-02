package com.patronesingsoft.behavioral.Observer;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/** SUJETO CONCRETO: publica avisos sin conocer clases concretas de alumnos. */
public class Curso implements Sujeto {
    private final Set<Observador> observadores = new LinkedHashSet<>();
    private String ultimoAviso = "";

    public void suscribir(Observador observador) { observadores.add(Objects.requireNonNull(observador)); }
    public void desuscribir(Observador observador) { observadores.remove(Objects.requireNonNull(observador)); }

    public void publicarAviso(String aviso) {
        if (aviso == null || aviso.isBlank()) throw new IllegalArgumentException("Aviso requerido");
        ultimoAviso = aviso;
        notificar();
    }

    public void notificar() {
        // Conserva el aviso de esta ronda aunque un observador publique otro.
        String aviso = ultimoAviso;
        // Una copia permite altas o bajas durante la notificación.
        // ponytail: entrega síncrona de un hilo; aislar fallos si hay receptores externos.
        for (Observador observador : new LinkedHashSet<>(observadores)) observador.actualizar(aviso);
    }
}
