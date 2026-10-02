package com.patronesingsoft.behavioral.Mediator;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/** MEDIADOR CONCRETO: centraliza registro y distribución de mensajes. */
public class SalaChat implements Mediador {
    private final Set<Usuario> usuarios = new LinkedHashSet<>();

    public void registrar(Usuario usuario) {
        Objects.requireNonNull(usuario);
        if (!usuario.pertenece(this)) throw new IllegalArgumentException("Usuario de otra sala");
        usuarios.add(usuario);
    }

    public void enviar(String mensaje, Usuario emisor) {
        if (!usuarios.contains(emisor)) throw new IllegalArgumentException("Emisor no registrado");
        if (mensaje == null || mensaje.isBlank()) throw new IllegalArgumentException("Mensaje requerido");
        for (Usuario usuario : usuarios) {
            if (usuario != emisor) usuario.recibir(emisor.getNombre() + ": " + mensaje);
        }
    }
}
