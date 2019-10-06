package com.adventure.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.adventure.components.InventorySpace;

public class InventoryPanel extends JPanel{

  private static final long serialVersionUID = 1L;

  private Integer capacity;
  private InventorySpace matrix[][];
  
  public InventoryPanel() {
    initialize();
  }
  
  private void initialize(){
    this.setPreferredSize(new Dimension(195, 180));
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public InventorySpace[][] getMatrix() {
    return matrix;
  }

  public void setMatrix(InventorySpace[][] matrix) {
    this.matrix = matrix;
  }
  
}
