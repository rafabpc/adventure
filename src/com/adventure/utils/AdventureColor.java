package com.adventure.utils;

import java.awt.Color;

public class AdventureColor extends Color{

  private static final long serialVersionUID = 1L;
  
  public static final AdventureColor BROWN = new AdventureColor(150, 75, 0);
  public static final AdventureColor PURPLE = new AdventureColor(153, 51, 153);
  
  public static final AdventureColor COPPER = new AdventureColor(205,92,92);
  public static final AdventureColor SILVER = new AdventureColor(192,192,192);
  public static final AdventureColor GOLD = new AdventureColor (218,165,32);
  public static final AdventureColor PLATINUM = new AdventureColor(102, 255, 204);
  public static final AdventureColor DIAMOND = new AdventureColor(0, 204, 255);
  public static final AdventureColor LEGENDARY = new AdventureColor(255, 153, 0);
  
  public static final AdventureColor BLOOD = new AdventureColor(139,0,0);
  
  public AdventureColor(int r, int g, int b) {
    super(r, g, b);
  }

  
  
}
