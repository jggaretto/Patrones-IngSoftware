package com.patronesingsoft.Patrones_Estructurales.Decorator;

public class Main {
    public static void main(String[] args) {
        Bebida bebida = new Cafe();
        mostrar(bebida);

        bebida = new ConLeche(bebida);   // envuelvo el cafe con leche
        mostrar(bebida);

        bebida = new ConAzucar(bebida);  // envuelvo de nuevo con azucar
        mostrar(bebida);
    }

    private static void mostrar(Bebida b) {
        System.out.println(b.descripcion() + " -> $" + b.precio());
    }
}
