package com.patronesingsoft.Patrones_Estructurales.Adapter;

/**
 * Datos del cliente que paga. Cada sistema externo necesita un dato distinto
 * (la pasarela usa el email, el banco usa el CBU), por eso se guardan los dos.
 */
public record Cliente(String nombre, String email, String cbu) {
}
