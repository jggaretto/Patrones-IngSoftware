package com.patronesingsoft.creational.FactoryMethod;

/** CREADOR CONCRETO: especializa solamente la creación del transporte. */
public class LogisticaTerrestre extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Camion();
    }
}
