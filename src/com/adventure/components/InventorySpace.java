package com.adventure.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.adventure.entity.Loot;

public class InventorySpace extends JLabel{

  private static final long serialVersionUID = 1L;
  
  private Integer line;
  private Integer column;
  private Loot loot;
  
  public InventorySpace() {
    this.setPreferredSize(new Dimension(36, 36));
    this.setBorder(new LineBorder(Color.black));
    this.setHorizontalAlignment(JLabel.CENTER);
    this.setOpaque(true);
  }

  public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public Integer getColumn() {
    return column;
  }

  public void setColumn(Integer column) {
    this.column = column;
  }

  public Loot getLoot() {
    return loot;
  }

  public void setLoot(Loot loot) {
    this.loot = loot;
  }
  
}
