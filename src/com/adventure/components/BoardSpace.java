package com.adventure.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.adventure.entity.Creature;
import com.adventure.type.FillType;
import com.adventure.type.FloorType;

public class BoardSpace extends JLabel{

  private static final long serialVersionUID = 1L;
  
  private String code;
  
  private Integer line;
  private Integer column;
  
  private FillType fillType;
  private FloorType floorType;
  
  private Creature creature;
  
  public BoardSpace() {
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

  public FillType getFillType() {
    return fillType;
  }

  public void setFillType(FillType fillType) {
    this.fillType = fillType;
  }

  public FloorType getFloorType() {
    return floorType;
  }

  public void setFloorType(FloorType floorType) {
    this.floorType = floorType;
  }

  public Creature getCreature() {
    return creature;
  }

  public void setCreature(Creature creature) {
    this.creature = creature;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
  
}
