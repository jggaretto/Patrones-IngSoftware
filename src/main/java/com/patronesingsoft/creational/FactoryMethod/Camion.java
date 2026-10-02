package com.patronesingsoft.creational.FactoryMethod;

/** PRODUCTO CONCRETO: entrega por carretera. */
public class Camion implements Transporte {
    @Override
    public String entregar() {
        return "Entrega por carretera en camion";
    }
}
