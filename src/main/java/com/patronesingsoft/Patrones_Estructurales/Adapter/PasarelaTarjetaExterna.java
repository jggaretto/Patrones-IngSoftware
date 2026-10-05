package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * ADAPTEE 1 (clase existente con interfaz incompatible).
 *
 * Simula la libreria de una pasarela de tarjetas de un tercero: no se puede
 * (ni se debe) modificar. Pide el email, el monto en CENTAVOS (long) y
 * devuelve un texto con el estado.
 */
public class PasarelaTarjetaExterna {

    public String crearCobro(String email, long centavos) {
        System.out.println("  [PasarelaTarjeta] Cobro creado para " + email + " por " + centavos + " centavos");
        return centavos > 0 ? "APROBADO" : "RECHAZADO";
    }
}
