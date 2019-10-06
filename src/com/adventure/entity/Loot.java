package com.adventure.entity;

import com.adventure.type.LootType;

public class Loot {

  private String name;
  private Integer buyPrice;
  private Integer sellPrice;
  private LootType lootType;
  
  public Loot() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Integer buyPrice) {
    this.buyPrice = buyPrice;
  }

  public Integer getSellPrice() {
    return sellPrice;
  }

  public void setSellPrice(Integer sellPrice) {
    this.sellPrice = sellPrice;
  }

  public LootType getLootType() {
    return lootType;
  }

  public void setLootType(LootType lootType) {
    this.lootType = lootType;
  }
  
}
