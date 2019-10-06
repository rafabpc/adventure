package com.adventure.main;

import com.adventure.engine.MapEditorEngine;
import com.adventure.view.MapEditorView;

public class MapEditor {

  public static void main(String[] args) {
    MapEditorView view = new MapEditorView();
    new MapEditorEngine(view);
    view.setVisible(true);
  }
  
}
