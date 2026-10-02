package com.patronesingsoft.creational.Builder;

/**
 * CLIENTE / DEMO - Punto de entrada para la exposición.
 *
 * Muestra los 3 usos del patrón:
 *  1. Con Director (recetas predefinidas).
 *  2. Sin Director (construcción personalizada paso a paso).
 *  3. Reutilización del mismo Builder para varios productos.
 *
 * Para ejecutar:
 *   mvn compile exec:java -Dexec.mainClass="com.patronesingsoft.creational.Builder.Demo"
 *   o directamente con el botón Run de tu IDE.
 */
public class Demo {

    public static void main(String[] args) {
        ComputadoraBuilder builder = new ComputadoraBuilderImpl();
        Director director = new Director();
        director.setBuilder(builder);

        System.out.println("=== 1. USO CON DIRECTOR (recetas predefinidas) ===\n");

        // --- PC Gamer ---
        Computadora gamer = director.construirPCGamer();
        System.out.println("PC Gamer armada por el Director:");
        System.out.println(gamer);

        // --- PC Oficina ---
        // Mismo builder, distinta receta -> distinto producto
        Computadora oficina = director.construirPCOficina();
        System.out.println("PC de Oficina armada por el Director:");
        System.out.println(oficina);

        System.out.println("=== 2. USO SIN DIRECTOR (100% personalizada) ===\n");
        System.out.println("El cliente controla cada paso, sin receta fija:");

        ComputadoraBuilder builderPersonalizado = new ComputadoraBuilderImpl();
        Computadora streamer = builderPersonalizado
                .setCPU("AMD Ryzen 9 7950X")
                .setRAM(64)
                .setAlmacenamiento(4000, "SSD NVMe")
                .setGPU("NVIDIA RTX 4090 24GB")
                .setSistemaOperativo("Windows 11 Pro")
                .setRefrigeracionLiquida(true)
                .setLucesRGB(true)
                .build();
        System.out.println("PC para Streaming (personalizada sin Director):");
        System.out.println(streamer);

        System.out.println("=== 3. REUTILIZACION DEL BUILDER ===\n");
        System.out.println("El mismo builder sirve para varios productos:");

        ComputadoraBuilder builderReutilizable = new ComputadoraBuilderImpl();
        director.setBuilder(builderReutilizable);

        Computadora economica = director.construirPCEconomica();
        System.out.println("PC Economica N.1:");
        System.out.println(economica);

        // El builder se reseteó solo en build(), se puede seguir usando
        Computadora otraEconomica = builderReutilizable
                .setCPU("Intel Core i3-12100")
                .setRAM(8)
                .setAlmacenamiento(512, "SSD")
                .setGPU("Graficos Integrados UHD 730")
                .setSistemaOperativo("Linux Mint")
                .setRefrigeracionLiquida(false)
                .setLucesRGB(false)
                .build();
        System.out.println("PC Economica N.2 (mismo builder, otra config):");
        System.out.println(otraEconomica);
        assert gamer.getRamGB() == 32 && gamer.hasLucesRGB();
        assert oficina.getRamGB() == 16 && !oficina.hasLucesRGB();
        assert streamer.getRamGB() == 64 && streamer.getAlmacenamientoGB() == 4000;
        assert economica != otraEconomica && economica.getCpu().equals("AMD Ryzen 5 5600G");

        Computadora minima = builderReutilizable.setCPU("CPU nueva").setRAM(4).build();
        assert minima != otraEconomica && minima.getGpu() == null && !minima.hasLucesRGB();
        assert otraEconomica.getAlmacenamientoGB() == 512 : "La nueva construcción no debe alterar la anterior";
        boolean incompleta = false;
        try { new ComputadoraBuilderImpl().build(); }
        catch (IllegalStateException e) { incompleta = true; }
        assert incompleta : "CPU y RAM son obligatorias";
        boolean ramInvalida = false;
        try { builderReutilizable.setRAM(0); }
        catch (IllegalArgumentException e) { ramInvalida = true; }
        assert ramInvalida;
        System.out.println("Builder: recetas, validaciones y reutilización verificadas.");
    }
}
