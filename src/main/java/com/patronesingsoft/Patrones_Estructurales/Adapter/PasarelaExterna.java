package com.patronesingsoft.Patrones_Estructurales.Adapter;

/** ADAPTEE: libreria de un tercero (no se puede modificar). Pide CENTAVOS y devuelve un texto. */
public class PasarelaExterna {
    public String cobrarEnCentavos(long centavos) {
        System.out.println("  [Pasarela] Cobrando " + centavos + " centavos");
        return centavos > 0 ? "APROBADO" : "RECHAZADO";
    }
}
