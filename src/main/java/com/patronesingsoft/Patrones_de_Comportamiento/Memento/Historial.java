package com.patronesingsoft.Patrones_de_Comportamiento.Memento;

import java.util.ArrayList;
import java.util.List;

// Caretaker : el que cuida las fotos
public class Historial {
  private final List<TextMemento> estados = new ArrayList<>();


  public void guardar(TextMemento memento){
    estados.add(memento);
  }

  public TextMemento deshacer(){
    if (estados.isEmpty()) {
      return null;
    }
    return estados.remove(estados.size() - 1);
  }


}
