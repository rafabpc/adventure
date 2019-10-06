package com.adventure.entity;

import java.util.List;

public class Inventory {

  private Integer totalSpace;
  private Integer emptySpace;
  private Integer occupiedSpace;
  private List<Loot> loots;
  
  public Inventory() {
  }

  public Integer getTotalSpace() {
    return totalSpace;
  }

  public void setTotalSpace(Integer totalSpace) {
    this.totalSpace = totalSpace;
  }

  public Integer getEmptySpace() {
    return emptySpace;
  }

  public void setEmptySpace(Integer emptySpace) {
    this.emptySpace = emptySpace;
  }

  public Integer getOccupiedSpace() {
    return occupiedSpace;
  }

  public void setOccupiedSpace(Integer occupiedSpace) {
    this.occupiedSpace = occupiedSpace;
  }

  public List<Loot> getLoots() {
    return loots;
  }

  public void setLoots(List<Loot> loots) {
    this.loots = loots;
  }

}
