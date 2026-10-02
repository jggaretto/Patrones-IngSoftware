package com.patronesingsoft.behavioral.Memento;

/** CLIENTE: respalda el estado antes de cada edición que quiere poder deshacer. */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Historial historial = new Historial(editor);
        assert !historial.deshacer();
        editor.escribir("Borrador");
        historial.respaldar();
        editor.escribir("Primera revision");
        historial.respaldar();
        editor.escribir("Version final");
        boolean primero = historial.deshacer();
        assert primero && editor.getTexto().equals("Primera revision");
        boolean segundo = historial.deshacer();
        assert segundo && editor.getTexto().equals("Borrador");
        assert !historial.deshacer();
        boolean ajena = false;
        try { editor.restaurar(new Editor().guardar()); }
        catch (IllegalArgumentException e) { ajena = true; }
        assert ajena && editor.getTexto().equals("Borrador");
        System.out.println("Estado restaurado: " + editor.getTexto());
    }
}
