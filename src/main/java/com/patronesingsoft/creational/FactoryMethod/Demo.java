package com.patronesingsoft.creational.FactoryMethod;

/** CLIENTE: el mismo pedido se procesa mediante dos creadores diferentes. */
public class Demo {
    public static void main(String[] args) {
        String terrestre = new LogisticaTerrestre().planificarEntrega();
        String maritima = new LogisticaMaritima().planificarEntrega();
        assert terrestre.equals("Entrega por carretera en camion");
        assert maritima.equals("Entrega por mar en barco");
        System.out.println(terrestre);
        System.out.println(maritima);
    }
}
