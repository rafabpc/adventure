package com.adventure.entity;

import com.adventure.type.MonsterType;

public class Monster extends Creature{

  private Integer gold;
  private Loot loot;
  private MonsterType type;
  
  public Monster() {
    
  }

  public MonsterType getType() {
    return type;
  }

  public void setType(MonsterType type) {
    this.type = type;
  }

  public Integer getGold() {
    return gold;
  }

  public void setGold(Integer gold) {
    this.gold = gold;
  }

  public Loot getLoot() {
    return loot;
  }

  public void setLoot(Loot loot) {
    this.loot = loot;
  }
  
}
