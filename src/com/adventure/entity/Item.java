package com.adventure.entity;

import com.adventure.type.ItemType;

public class Item extends Loot{

  private ItemType type;
  private Integer bonus;
  
  public Item() {
    
  }

  public ItemType getType() {
    return type;
  }

  public void setType(ItemType type) {
    this.type = type;
  }

  public Integer getBonus() {
    return bonus;
  }

  public void setBonus(Integer bonus) {
    this.bonus = bonus;
  }
  
}
