package com.patronesingsoft.Patrones_de_Comportamiento.Memento;

// Client : ejecuta el ejemplo del patron Memento
public class Main {
  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    Historial historial = new Historial();

    editor.escribir(" Cambio 1 ");
    historial.guardar(editor.guardarEstado());
    editor.mostrar();

    editor.escribir(" Cambio 2 ");
    historial.guardar(editor.guardarEstado());
    editor.mostrar();

    editor.escribir(" Cambio 3 ");
    editor.mostrar();

    System.out.println("Deshacer ultimo cambio");
    editor.restaurar(historial.deshacer());
    editor.mostrar();

    System.out.println("Deshacer otro cambio");
    editor.restaurar(historial.deshacer());
    editor.mostrar();
  }
}
