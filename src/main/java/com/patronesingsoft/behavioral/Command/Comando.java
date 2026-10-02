package com.patronesingsoft.behavioral.Command;

/** COMANDO: encapsula una operación y cómo deshacerla. */
public interface Comando {
    void ejecutar();
    void deshacer();
}
