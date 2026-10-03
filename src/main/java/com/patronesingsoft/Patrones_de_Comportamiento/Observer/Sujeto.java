package com.patronesingsoft.Patrones_de_Comportamiento.Observer;

/** SUJETO: permite suscripción, baja y notificación de observadores. */
public interface Sujeto {
    void suscribir(Observador observador);
    void desuscribir(Observador observador);
    void notificar();
}
