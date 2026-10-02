package com.patronesingsoft.creational.Builder;

/**
 * BUILDER (Interfaz abstracta) - Declara los pasos de construcción.
 *
 * Todos los builders concretos siguen estos pasos para armar una Computadora.
 * Retorna el propio builder para permitir encadenamiento fluido:
 *   builder.setCPU(...).setRAM(...).setGPU(...).build()
 */
public interface ComputadoraBuilder {

    void reset();

    ComputadoraBuilder setCPU(String cpu);

    ComputadoraBuilder setRAM(int ramGB);

    ComputadoraBuilder setAlmacenamiento(int gb, String tipo);

    ComputadoraBuilder setGPU(String gpu);

    ComputadoraBuilder setSistemaOperativo(String so);

    ComputadoraBuilder setRefrigeracionLiquida(boolean tiene);

    ComputadoraBuilder setLucesRGB(boolean tiene);

    /**
     * Devuelve el producto terminado y lo deja listo para una nueva construcción.
     */
    Computadora build();
}
