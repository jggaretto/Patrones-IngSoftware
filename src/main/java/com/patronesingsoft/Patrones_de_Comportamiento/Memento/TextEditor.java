package com.patronesingsoft.Patrones_de_Comportamiento.Memento;

// Originator : el que tiene el estado
public class TextEditor {

  private String texto = "";

  public void escribir(String t){
    this.texto += t;
  }

  public void mostrar(){
    System.out.println("Texto: " + texto);
  }

  public void restaurar(TextMemento memento){
    this.texto = memento.getText();
  }

  public TextMemento guardarEstado() {
    return new TextMemento(texto);
  }

}
