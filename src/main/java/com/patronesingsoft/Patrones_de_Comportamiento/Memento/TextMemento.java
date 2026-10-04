package com.patronesingsoft.Patrones_de_Comportamiento.Memento;

public class TextMemento {
  private final String text;

  public TextMemento(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
