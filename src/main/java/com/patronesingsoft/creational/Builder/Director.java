package com.patronesingsoft.creational.Builder;

/**
 * DIRECTOR - Define recetas de construcción predefinidas.
 *
 * El Director NO crea el producto directamente: solo orquesta
 * los pasos del Builder. Así el cliente puede pedir
 * "una gamer" o "una de oficina" sin conocer los detalles.
 *
 * El Director es OPCIONAL: también se puede usar el Builder
 * manualmente para una configuración 100% personalizada.
 */
public class Director {

    private ComputadoraBuilder builder;

    public void setBuilder(ComputadoraBuilder builder) {
        this.builder = java.util.Objects.requireNonNull(builder);
    }

    /** Receta 1: PC Gamer de alta gama. */
    public Computadora construirPCGamer() {
        return builder
                .setCPU("Intel Core i9-13900K")
                .setRAM(32)
                .setAlmacenamiento(2000, "SSD NVMe")
                .setGPU("NVIDIA RTX 4070 12GB")
                .setSistemaOperativo("Windows 11 Pro")
                .setRefrigeracionLiquida(true)
                .setLucesRGB(true)
                .build();
    }

    /** Receta 2: PC de Oficina económica y funcional. */
    public Computadora construirPCOficina() {
        return builder
                .setCPU("Intel Core i5-12400")
                .setRAM(16)
                .setAlmacenamiento(512, "SSD")
                .setGPU("Graficos Integrados UHD 730")
                .setSistemaOperativo("Windows 11 Home")
                .setRefrigeracionLiquida(false)
                .setLucesRGB(false)
                .build();
    }

    /** Receta 3: PC economica para estudiantes. */
    public Computadora construirPCEconomica() {
        return builder
                .setCPU("AMD Ryzen 5 5600G")
                .setRAM(8)
                .setAlmacenamiento(256, "SSD")
                .setGPU("Graficos Integrados Vega 7")
                .setSistemaOperativo("Linux Ubuntu 24.04")
                .setRefrigeracionLiquida(false)
                .setLucesRGB(false)
                .build();
    }
}
