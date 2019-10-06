package com.adventure.entity;

import com.adventure.type.LootType;

public class Creature {

  private String name;
  private Integer maxLife;
  private Integer currentlyLife;
  private Integer attack;
  private Integer defense;
  private Integer exp;
  private Double lootChance;
  private LootType lootType;
  
  public Creature() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMaxLife() {
    return maxLife;
  }

  public void setMaxLife(Integer maxLife) {
    this.maxLife = maxLife;
  }

  public Integer getCurrentlyLife() {
    return currentlyLife;
  }

  public void setCurrentlyLife(Integer currentlyLife) {
    this.currentlyLife = currentlyLife;
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

  public Integer getExp() {
    return exp;
  }

  public void setExp(Integer exp) {
    this.exp = exp;
  }

  public Double getLootChance() {
    return lootChance;
  }

  public void setLootChance(Double lootChance) {
    this.lootChance = lootChance;
  }

  public LootType getLootType() {
    return lootType;
  }

  public void setLootType(LootType lootType) {
    this.lootType = lootType;
  }
  
}
