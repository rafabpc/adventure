package com.adventure.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class EquipmentPanel extends JPanel{

  private static final long serialVersionUID = 1L;

  private JLabel helmetEquip;
  private JLabel breastplateEquip;
  private JLabel weaponEquip;
  private JLabel shieldEquip;
  private JLabel paintsEquip;
  private JLabel bootsEquip;
  
  public EquipmentPanel() {
    initialize();
  }
  
  private void initialize(){
    this.setPreferredSize(new Dimension(195, 290));
    this.setLayout(new GridLayout(4, 1));
    
    JPanel helmetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    helmetPanel.setPreferredSize(new Dimension(195, 70));
    helmetPanel.setBackground(Color.white);
    helmetPanel.setOpaque(true);
    helmetPanel.add(getHelmetEquip());
    this.add(helmetPanel);
    
    JPanel breastplatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    breastplatePanel.setPreferredSize(new Dimension(195, 70));
    breastplatePanel.setBackground(Color.white);
    breastplatePanel.setOpaque(true);
    breastplatePanel.add(getWeaponEquip());
    breastplatePanel.add(getBreastplateEquip());
    breastplatePanel.add(getShieldEquip());
    this.add(breastplatePanel);
    
    JPanel paintsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    paintsPanel.setPreferredSize(new Dimension(195, 70));
    paintsPanel.setBackground(Color.white);
    paintsPanel.setOpaque(true);
    paintsPanel.add(getPaintsEquip());
    this.add(paintsPanel);
    
    JPanel bootsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    bootsPanel.setPreferredSize(new Dimension(195, 70));
    bootsPanel.setBackground(Color.white);
    bootsPanel.setOpaque(true);
    bootsPanel.add(getBootsEquip());
    this.add(bootsPanel);
    
  }

  public JLabel getHelmetEquip() {
    if(helmetEquip == null){
      helmetEquip = new JLabel();
      helmetEquip.setBorder(new LineBorder(Color.black));
      helmetEquip.setPreferredSize(new Dimension(60, 60));
      helmetEquip.setOpaque(true);
    }
    return helmetEquip;
  }

  public JLabel getBreastplateEquip() {
    if(breastplateEquip == null){
      breastplateEquip = new JLabel();
      breastplateEquip.setBorder(new LineBorder(Color.black));
      breastplateEquip.setPreferredSize(new Dimension(60, 60));
      breastplateEquip.setOpaque(true);
    }
    return breastplateEquip;
  }

  public JLabel getWeaponEquip() {
    if(weaponEquip == null){
      weaponEquip = new JLabel();
      weaponEquip.setBorder(new LineBorder(Color.black));
      weaponEquip.setPreferredSize(new Dimension(60, 60));
      weaponEquip.setOpaque(true);
    }
    return weaponEquip;
  }

  public JLabel getShieldEquip() {
    if(shieldEquip == null){
      shieldEquip = new JLabel();
      shieldEquip.setBorder(new LineBorder(Color.black));
      shieldEquip.setPreferredSize(new Dimension(60, 60));
      shieldEquip.setOpaque(true);
    }
    return shieldEquip;
  }

  public JLabel getPaintsEquip() {
    if(paintsEquip == null){
      paintsEquip = new JLabel();
      paintsEquip.setBorder(new LineBorder(Color.black));
      paintsEquip.setPreferredSize(new Dimension(60, 60));
      paintsEquip.setOpaque(true);
    }
    return paintsEquip;
  }

  public JLabel getBootsEquip() {
    if(bootsEquip == null){
      bootsEquip = new JLabel();
      bootsEquip.setBorder(new LineBorder(Color.black));
      bootsEquip.setPreferredSize(new Dimension(60, 60));
      bootsEquip.setOpaque(true);
    }
    return bootsEquip;
  }
  
  
}
