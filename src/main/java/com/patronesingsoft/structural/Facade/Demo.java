package com.patronesingsoft.structural.Facade;

/** CLIENTE: una llamada expresa la compra completa. */
public class Demo {
    public static void main(String[] args) {
        TiendaFacade tienda = new TiendaFacade(new Inventario(), new Pago(), new Envio());
        String compra = tienda.comprar("Libro", 150000);
        assert compra.equals("Pago aprobado: 150000 centavos | Envio preparado: Libro");
        boolean sinStock = false;
        try { tienda.comprar("Cuaderno", 1000); } catch (IllegalStateException e) { sinStock = true; }
        assert sinStock;
        boolean importeInvalido = false;
        try { tienda.comprar("Libro", 0); } catch (IllegalArgumentException e) { importeInvalido = true; }
        assert importeInvalido;
        System.out.println(compra);
    }
}
