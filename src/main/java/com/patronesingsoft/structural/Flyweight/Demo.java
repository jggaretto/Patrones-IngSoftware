package com.patronesingsoft.structural.Flyweight;

/** CLIENTE: varios árboles comparten su especie, pero no su ubicación. */
public class Demo {
    public static void main(String[] args) {
        FabricaTipos fabrica = new FabricaTipos();
        Arbol primero = new Arbol(1, 2, fabrica.obtener("Pino"));
        Arbol segundo = new Arbol(9, 4, fabrica.obtener("Pino"));
        Arbol tercero = new Arbol(0, 0, fabrica.obtener("Roble"));
        assert primero.getTipo() == segundo.getTipo();
        assert primero.getTipo() != tercero.getTipo();
        assert fabrica.cantidadTipos() == 2;
        assert primero.dibujar().equals("Pino en (1, 2)");
        assert segundo.dibujar().equals("Pino en (9, 4)");
        System.out.println(primero.dibujar());
        System.out.println(segundo.dibujar());
        System.out.println("Tipos compartidos: " + fabrica.cantidadTipos());
    }
}
