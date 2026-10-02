package com.patronesingsoft.behavioral.Observer;

/** SUJETO: permite suscripción, baja y notificación de observadores. */
public interface Sujeto {
    void suscribir(Observador observador);
    void desuscribir(Observador observador);
    void notificar();
}
