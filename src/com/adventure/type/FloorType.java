package com.adventure.type;

import java.awt.Color;

import com.adventure.utils.AdventureColor;

public enum FloorType {
  
  STONE   ("P", AdventureColor.DARK_GRAY),
  GROUND   ("T", AdventureColor.BROWN),
  WATER    ("A", AdventureColor.BLUE),
  FIRE    ("F", AdventureColor.RED),
  POISON  ("V", AdventureColor.YELLOW),
  GRASS   ("G", AdventureColor.GREEN);
  
  private String id;
  private Color color;
  
  private FloorType(String id, Color color) {
    this.id = id;
    this.color = color;
  }

  public String getId() {
    return id;
  }

  public Color getColor() {
    return color;
  }
  
  public static FloorType getTypeById(String id){
    if(id.equals(STONE.getId())){
      return STONE;
    }
    else if(id.equals(GROUND.getId())){
      return GROUND;
    }
    else if(id.equals(WATER.getId())){
      return WATER;
    }
    else if(id.equals(FIRE.getId())){
      return FIRE;
    }
    else if(id.equals(POISON.getId())){
      return POISON;
    }
    else{
      return GRASS;
    }
  }
  
  public static Color getColorById(String id){
    if(id.equals(STONE.getId())){
      return STONE.getColor();
    }
    else if(id.equals(GROUND.getId())){
      return GROUND.getColor();
    }
    else if(id.equals(WATER.getId())){
      return WATER.getColor();
    }
    else if(id.equals(FIRE.getId())){
      return FIRE.getColor();
    }
    else if(id.equals(POISON.getId())){
      return POISON.getColor();
    }
    else{
      return GRASS.getColor();
    }
  }
  
}
