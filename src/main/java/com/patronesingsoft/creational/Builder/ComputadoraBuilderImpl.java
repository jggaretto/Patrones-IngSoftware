package com.patronesingsoft.creational.Builder;

/**
 * CONCRETE BUILDER - Implementacion unica del Builder.
 * Arma una Computadora paso a paso y permite encadenamiento fluido.
 * La diferencia entre una PC Gamer / Oficina / Economica
 * NO esta aca, la define el Director o el cliente al usarlo.
 */
public class ComputadoraBuilderImpl implements ComputadoraBuilder {

    private Computadora computadora;

    public ComputadoraBuilderImpl() {
        this.computadora = new Computadora();
    }

    @Override
    public void reset() {
        this.computadora = new Computadora();
    }

    @Override
    public ComputadoraBuilder setCPU(String cpu) {
        if (cpu == null || cpu.isBlank()) throw new IllegalArgumentException("CPU requerida");
        computadora.setCpu(cpu);
        return this;
    }

    @Override
    public ComputadoraBuilder setRAM(int ramGB) {
        if (ramGB <= 0) throw new IllegalArgumentException("RAM positiva requerida");
        computadora.setRamGB(ramGB);
        return this;
    }

    @Override
    public ComputadoraBuilder setAlmacenamiento(int gb, String tipo) {
        if (gb <= 0 || tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Almacenamiento positivo y tipo requeridos");
        }
        computadora.setAlmacenamientoGB(gb);
        computadora.setTipoAlmacenamiento(tipo);
        return this;
    }

    @Override
    public ComputadoraBuilder setGPU(String gpu) {
        if (gpu == null || gpu.isBlank()) throw new IllegalArgumentException("GPU requerida");
        computadora.setGpu(gpu);
        return this;
    }

    @Override
    public ComputadoraBuilder setSistemaOperativo(String so) {
        if (so == null || so.isBlank()) throw new IllegalArgumentException("Sistema operativo requerido");
        computadora.setSistemaOperativo(so);
        return this;
    }

    @Override
    public ComputadoraBuilder setRefrigeracionLiquida(boolean tiene) {
        computadora.setRefrigeracionLiquida(tiene);
        return this;
    }

    @Override
    public ComputadoraBuilder setLucesRGB(boolean tiene) {
        computadora.setLucesRGB(tiene);
        return this;
    }

    @Override
    public Computadora build() {
        if (computadora.getCpu() == null || computadora.getCpu().isBlank()
                || computadora.getRamGB() <= 0) {
            throw new IllegalStateException("Configurar CPU y RAM antes de construir");
        }
        Computadora resultado = this.computadora;
        this.reset(); // deja el builder listo para reutilizar
        return resultado;
    }
}
