package com.adventure.entity;

import com.adventure.type.EquipmentType;
import com.adventure.utils.AdventureColor;

public class Equipment extends Loot{
  
  private Integer attack;
  private Integer defense;
  private EquipmentType type;
  private AdventureColor color;
  
  public Equipment() {

  }

  public Integer getAttack() {
    return attack;
  }

  public void setAttack(Integer attack) {
    this.attack = attack;
  }

  public Integer getDefense() {
    return defense;
  }

  public void setDefense(Integer defense) {
    this.defense = defense;
  }

  public EquipmentType getType() {
    return type;
  }

  public void setTipo(EquipmentType type) {
    this.type = type;
  }

  public AdventureColor getColor() {
    return color;
  }

  public void setColor(AdventureColor color) {
    this.color = color;
  }
 
}
