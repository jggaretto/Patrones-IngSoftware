package com.patronesingsoft.structural.Proxy;

/** CLIENTE: utiliza Imagen sin exigir que ya exista una ImagenReal. */
public class Demo {
    public static void main(String[] args) {
        ProxyImagen proxy = new ProxyImagen("campus.png");
        assert !proxy.estaCargada();
        Imagen imagen = proxy;
        String primera = imagen.mostrar();
        ImagenReal cargada = proxy.getReal();
        assert primera.equals("Mostrando campus.png");
        assert proxy.estaCargada();
        String segunda = imagen.mostrar();
        assert segunda.equals(primera);
        assert proxy.getReal() == cargada : "Debe reutilizar la imagen cargada";
        System.out.println(segunda);
    }
}
