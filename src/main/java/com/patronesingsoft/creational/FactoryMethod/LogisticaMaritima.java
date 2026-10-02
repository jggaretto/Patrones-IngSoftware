package com.patronesingsoft.creational.FactoryMethod;

/** CREADOR CONCRETO: produce barcos para el mismo flujo de entrega. */
public class LogisticaMaritima extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Barco();
    }
}
