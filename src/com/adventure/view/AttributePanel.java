package com.adventure.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.adventure.utils.AdventureColor;

public class AttributePanel extends JPanel{

  private static final long serialVersionUID = 1L;
  
  private JLabel labelName;
  private JLabel labelLevel;
  private JLabel labelExp;
  private JLabel labelAttack;
  private JLabel labelDefense;
  private JLabel labelLife;
  private JLabel labelGold;
  
  private JLabel valueName;
  private JLabel valueLevel;
  private JLabel valueExp;
  private JLabel valueAttack;
  private JLabel valueDefense;
  private JLabel valueLife;
  private JLabel valueGold;
  
  public AttributePanel() {
    initialize();
  }
  
  private void initialize(){
    this.setBackground(Color.white);
    this.setOpaque(true);
    this.setPreferredSize(new Dimension(205, 100));
    this.setLayout(new GridLayout(7, 2));
    
    this.add(getLabelName());
    this.add(getValueName());
    
    this.add(getLabelLevel());
    this.add(getValueLevel());
    
    this.add(getLabelExp());
    this.add(getValueExp());
    
    this.add(getLabelAttack());
    this.add(getValueAttack());
    
    this.add(getLabelDefense());
    this.add(getValueDefense());
    
    this.add(getLabelLife());
    this.add(getValueLife());
    
    this.add(getLabelGold());
    this.add(getValueGold());
  }

  private JLabel getLabelName() {
    if(labelName == null){
      labelName = new JLabel("Name:");
    }
    return labelName;
  }

  private JLabel getLabelLevel() {
    if(labelLevel == null){
      labelLevel = new JLabel("Level:");
    }
    return labelLevel;
  }

  private JLabel getLabelExp() {
    if(labelExp == null){
      labelExp = new JLabel("Exp:");
    }
    return labelExp;
  }

  private JLabel getLabelAttack() {
    if(labelAttack == null){
      labelAttack = new JLabel("Attack:");
    }
    return labelAttack;
  }

  private JLabel getLabelDefense() {
    if(labelDefense == null){
      labelDefense = new JLabel("Defense:");
    }
    return labelDefense;
  }

  private JLabel getLabelLife() {
    if(labelLife == null){
      labelLife = new JLabel("Life:");
      labelLife.setFont(new Font("arial", Font.BOLD, 12));
      labelLife.setForeground(AdventureColor.BLOOD);
    }
    return labelLife;
  }

  private JLabel getLabelGold() {
    if(labelGold == null){
      labelGold = new JLabel("Gold:");
      labelGold.setFont(new Font("arial", Font.BOLD, 12));
      labelGold.setForeground(AdventureColor.GOLD);
    }
    return labelGold;
  }

  public JLabel getValueName() {
    if(valueName == null){
      valueName = new JLabel();
    }
    return valueName;
  }

  public JLabel getValueLevel() {
    if(valueLevel == null){
      valueLevel = new JLabel();
    }
    return valueLevel;
  }

  public JLabel getValueExp() {
    if(valueExp == null){
      valueExp = new JLabel();
    }
    return valueExp;
  }

  public JLabel getValueAttack() {
    if(valueAttack == null){
      valueAttack = new JLabel();
    }
    return valueAttack;
  }

  public JLabel getValueDefense() {
    if(valueDefense == null){
      valueDefense = new JLabel();
    }
    return valueDefense;
  }

  public JLabel getValueLife() {
    if(valueLife == null){
      valueLife = new JLabel();
      valueLife.setFont(new Font("arial", Font.BOLD, 12));
      valueLife.setForeground(AdventureColor.BLOOD);
    }
    return valueLife;
  }

  public JLabel getValueGold() {
    if(valueGold == null){
      valueGold = new JLabel();
      valueGold.setFont(new Font("arial", Font.BOLD, 12));
      valueGold.setForeground(AdventureColor.GOLD);
    }
    return valueGold;
  }
  
}
