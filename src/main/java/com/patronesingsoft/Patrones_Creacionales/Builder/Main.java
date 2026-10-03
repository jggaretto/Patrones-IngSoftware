package com.patronesingsoft.Patrones_Creacionales.Builder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> productos = List.of(
                "Teclado",
                "Mouse"
        );

        Pedido pedido = new Pedido.Builder("Messi")
                .productos(productos)
                .direccion("Av. Mitre 123")
                .descuento(10)
                .envioExpress(true)
                .observaciones("Entregar por la tarde")
                .build();

        System.out.println(pedido);
    }
}