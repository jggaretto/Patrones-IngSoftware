package com.patronesingsoft.creational.Builder;

/**
 * PRODUCTO - Representa el objeto complejo que queremos construir.
 *
 * Una Computadora tiene muchos atributos (algunos obligatorios, otros opcionales).
 * Sin Builder terminaríamos con un constructor telescópico:
 *   new Computadora("i9", 32, 1000, "SSD", "RTX 4070", "Windows 11", true, true)
 * ... ilegible y propenso a errores.
 */
public class Computadora {
    private String cpu;
    private int ramGB;
    private int almacenamientoGB;
    private String tipoAlmacenamiento; // "SSD" o "HDD"
    private String gpu;
    private String sistemaOperativo;
    private boolean refrigeracionLiquida;
    private boolean lucesRGB;

    // Getters y Setters (el Builder los usa paso a paso)
    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    public int getRamGB() { return ramGB; }
    public void setRamGB(int ramGB) { this.ramGB = ramGB; }

    public int getAlmacenamientoGB() { return almacenamientoGB; }
    public void setAlmacenamientoGB(int almacenamientoGB) { this.almacenamientoGB = almacenamientoGB; }

    public String getTipoAlmacenamiento() { return tipoAlmacenamiento; }
    public void setTipoAlmacenamiento(String tipoAlmacenamiento) { this.tipoAlmacenamiento = tipoAlmacenamiento; }

    public String getGpu() { return gpu; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }

    public boolean hasRefrigeracionLiquida() { return refrigeracionLiquida; }
    public void setRefrigeracionLiquida(boolean refrigeracionLiquida) { this.refrigeracionLiquida = refrigeracionLiquida; }

    public boolean hasLucesRGB() { return lucesRGB; }
    public void setLucesRGB(boolean lucesRGB) { this.lucesRGB = lucesRGB; }

    @Override
    public String toString() {
        return "----------------------------------\n" +
               " COMPUTADORA\n" +
               "----------------------------------\n" +
               " CPU: " + cpu + "\n" +
               " RAM: " + ramGB + " GB\n" +
               " Disco: " + almacenamientoGB + " GB " + tipoAlmacenamiento + "\n" +
               " GPU: " + gpu + "\n" +
               " SO: " + sistemaOperativo + "\n" +
               " Refrigeracion liquida: " + (refrigeracionLiquida ? "Si" : "No") + "\n" +
               " Luces RGB: " + (lucesRGB ? "Si" : "No") + "\n" +
               "----------------------------------\n";
    }
}
