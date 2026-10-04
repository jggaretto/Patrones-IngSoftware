package com.patronesingsoft.Patrones_Estructurales.Facade;

/**
 * Subsistema de biblioteca.
 */
public class ServicioBiblioteca {

    public void habilitarPrestamo(String legajo) {
        System.out.println("  [Biblioteca] Prestamo habilitado para " + legajo);
    }

    public void revocarPrestamo(String legajo) {
        System.out.println("  [Biblioteca] Prestamo revocado para " + legajo);
    }
}