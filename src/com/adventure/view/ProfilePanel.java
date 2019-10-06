package com.adventure.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ProfilePanel extends JPanel{


  private static final long serialVersionUID = 1L;
  private EquipmentPanel equipmentPanel;
  private AttributePanel attributePanel;
  private InventoryPanel inventoryPanel;
  
  public ProfilePanel() {
    this.setBackground(Color.white);
    this.setOpaque(true);
    this.setLayout(new GridLayout(3, 1, 20, 20));
    this.setPreferredSize(new Dimension(200, 800));
    this.add(getEquipmentPanel());
    this.add(getAttributePanel());
    this.add(getInventoryPanel());
  }

  public EquipmentPanel getEquipmentPanel() {
    if(equipmentPanel == null){
      equipmentPanel = new EquipmentPanel();
    }
    return equipmentPanel;
  }

  public AttributePanel getAttributePanel() {
    if(attributePanel == null){
      attributePanel = new AttributePanel();
    }
    return attributePanel;
  }

  public InventoryPanel getInventoryPanel() {
    if(inventoryPanel == null){
      inventoryPanel = new InventoryPanel();
    }
    return inventoryPanel;
  }
  
  
}
