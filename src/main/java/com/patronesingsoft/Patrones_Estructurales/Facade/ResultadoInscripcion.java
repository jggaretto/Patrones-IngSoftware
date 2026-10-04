package com.patronesingsoft.Patrones_Estructurales.Facade;

/**
 * Resultado de una inscripcion procesada por la fachada.
 * Es el unico tipo que el cliente necesita conocer del subsistema.
 */
public record ResultadoInscripcion(boolean exitoso, String legajo, String mensaje) {
}