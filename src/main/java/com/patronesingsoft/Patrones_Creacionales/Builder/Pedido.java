package com.patronesingsoft.Patrones_Creacionales.Builder;

import java.util.List;

public class Pedido {

    private String cliente;
    private List<String> productos;
    private String direccion;
    private double descuento;
    private boolean envioExpress;
    private String observaciones;

    // Constructor privado
    private Pedido(Builder builder) {
        this.cliente = builder.cliente;
        this.productos = builder.productos;
        this.direccion = builder.direccion;
        this.descuento = builder.descuento;
        this.envioExpress = builder.envioExpress;
        this.observaciones = builder.observaciones;
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getProductos() {
        return productos;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getDescuento() {
        return descuento;
    }

    public boolean isEnvioExpress() {
        return envioExpress;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                ", productos=" + productos +
                ", direccion='" + direccion + '\'' +
                ", descuento=" + descuento +
                ", envioExpress=" + envioExpress +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }

    // BUILDER
    public static class Builder {

        private String cliente;
        private List<String> productos;
        private String direccion;
        private double descuento;
        private boolean envioExpress;
        private String observaciones;

        public Builder(String cliente) {
            this.cliente = cliente;
        }

        public Builder productos(List<String> productos) {
            this.productos = productos;
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder descuento(double descuento) {
            this.descuento = descuento;
            return this;
        }

        public Builder envioExpress(boolean envioExpress) {
            this.envioExpress = envioExpress;
            return this;
        }

        public Builder observaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }

        public Pedido build() {
            return new Pedido(this);
        }
    }
}