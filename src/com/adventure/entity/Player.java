package com.adventure.entity;

import java.util.List;

public class Player extends Creature{

  private Inventory inventory;
  private List<Equipment> equippedEquipments;
  private Integer gold;
  private Integer level;
  
  public Player() {
    
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  public List<Equipment> getEquippedEquipments() {
    return equippedEquipments;
  }

  public void setEquippedEquipments(List<Equipment> equippedEquipments) {
    this.equippedEquipments = equippedEquipments;
  }

  public Integer getGold() {
    return gold;
  }

  public void setGold(Integer gold) {
    this.gold = gold;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }
  
}
