package com.patronesingsoft.creational.FactoryMethod;

/** PRODUCTO CONCRETO: entrega por mar. */
public class Barco implements Transporte {
    @Override
    public String entregar() {
        return "Entrega por mar en barco";
    }
}
