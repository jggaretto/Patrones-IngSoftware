package com.patronesingsoft.Patrones_de_Comportamiento.Observer;

/** OBSERVADOR: contrato para recibir avisos del sujeto. */
public interface Observador {
    void actualizar(String aviso);
}
