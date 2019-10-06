package com.adventure.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.adventure.utils.AdventureColor;

public class BattleView extends JDialog{

  private static final long serialVersionUID = 1L;
  private JPanel mainPanel;
  
  
  private JPanel playerPanel;
  private JPanel playerActionsPanel;
  private JButton attackButton;
  private JButton escapeButton;
  private JButton exitButton;
  private JLabel turnIndicatorLabel;
  private AttributePanel attributePanel;
  private InventoryPanel inventoryPanel;
  
 
  private JPanel battlePanel;
  private JScrollPane scrollPanel;
  private JTable battleTable;
  private DefaultTableModel tableModel;
  private String[] columns = new String[]{"Attack", "Description", "Defense"};
  
 
  private JPanel monsterPanel;
  private JPanel monsterIdentificationPanel;
  private JLabel monsterIdentificationLabel;
  private JPanel monsterImagePanel;
  private JLabel monsterImageLabel;
  private JPanel monsterAttributePanel;
  
  private JLabel monsterLifeLabel;
  private JLabel monsterLifeValue;
  private JLabel monsterAttackLabel;
  private JLabel monsterAttackValue;
  private JLabel monsterDefenseLabel;
  private JLabel monsterDefenseValue;
  private JLabel monsterGoldLabel;
  private JLabel monsterGoldValue;
  private JLabel monsterExpLabel;
  private JLabel monsterExpValue;
  
  
  public BattleView() {
    initialize();
  }
  
  private void initialize(){
    this.setSize(new Dimension(800, 450));
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.setContentPane(getMainPanel());
  }
  
  public JPanel getMainPanel() {
    if(mainPanel == null){
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(getPlayerPanel(), BorderLayout.WEST);
      mainPanel.add(getBattlePanel(), BorderLayout.CENTER);
      mainPanel.add(getMonsterPanel(), BorderLayout.EAST);
    }
    return mainPanel;
  }
  
  public JPanel getBattlePanel() {
    if(battlePanel == null){
      battlePanel = new JPanel();
      battlePanel.setLayout(new BorderLayout());
      battlePanel.add(getScrollPanel(), BorderLayout.CENTER);
    }
    return battlePanel;
  }
  
  public JScrollPane getScrollPanel() {
    if(scrollPanel == null){
      scrollPanel = new JScrollPane();
      scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPanel.setViewportView(getBattleTable());
    }
    return scrollPanel;
  }
  
  public JTable getBattleTable() {
    if(battleTable == null){
      battleTable = new JTable();
      battleTable.setModel(getTableModel());
    }
    return battleTable;
  }
  
  public DefaultTableModel getTableModel() {
    if(tableModel == null){
      tableModel = new DefaultTableModel();
      for(String column : columns){
        tableModel.addColumn(column);
      }
    }
    return tableModel;
  }
  
  public JPanel getMonsterPanel() {
    if(monsterPanel == null){
      monsterPanel = new JPanel();
      monsterPanel.setLayout(new BorderLayout());
      monsterPanel.setPreferredSize(new Dimension(250, 400));
      monsterPanel.add(getMonsterIdentificationPanel(), BorderLayout.NORTH);
      monsterPanel.add(getMonsterImagePanel(), BorderLayout.CENTER);
      monsterPanel.add(getMonsterAttributePanel(), BorderLayout.SOUTH);
    }
    return monsterPanel;
  }
  
  public JPanel getPlayerPanel() {
    if(playerPanel == null){
      playerPanel = new JPanel();
      playerPanel.setLayout(new BorderLayout());
      playerPanel.setPreferredSize(new Dimension(250, 400));
      playerPanel.add(getPlayerActionsPanel(), BorderLayout.NORTH);
      playerPanel.add(getAttributePanel(), BorderLayout.CENTER);
      playerPanel.add(getInventoryPanel(), BorderLayout.SOUTH);
    }
    return playerPanel;
  }
  
  public JPanel getPlayerActionsPanel() {
    if(playerActionsPanel == null){
      playerActionsPanel = new JPanel();
      playerActionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      playerActionsPanel.setPreferredSize(new Dimension(250, 40));
      playerActionsPanel.add(getAttackButton());
      playerActionsPanel.add(getEscapeButton());
      playerActionsPanel.add(getExitButton());
      playerActionsPanel.add(getTurnIndicatorLabel());
    }
    return playerActionsPanel;
  }
  
  public JButton getAttackButton() {
    if(attackButton == null){
      attackButton = new JButton("Attack");
    }
    return attackButton;
  }
  
  public JButton getEscapeButton() {
    if(escapeButton == null){
      escapeButton = new JButton("Escape");
    }
    return escapeButton;
  }
  
  public JButton getExitButton() {
    if(exitButton == null){
      exitButton = new JButton("Exit");
    }
    return exitButton;
  }
  
  public JLabel getTurnIndicatorLabel() {
    if(turnIndicatorLabel == null){
      turnIndicatorLabel = new JLabel();
      turnIndicatorLabel.setBorder(new LineBorder(Color.black));
      turnIndicatorLabel.setOpaque(true);
      turnIndicatorLabel.setPreferredSize(new Dimension(16, 16));
    }
    return turnIndicatorLabel;
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
  
  public JPanel getMonsterIdentificationPanel() {
    if(monsterIdentificationPanel == null){
      monsterIdentificationPanel = new JPanel();
      monsterIdentificationPanel.setLayout(new GridLayout(1, 1));
      monsterIdentificationPanel.setPreferredSize(new Dimension(250, 30));
      monsterIdentificationPanel.add(getMonsterIdentificationLabel());
    }
    return monsterIdentificationPanel;
  }
  
  public JLabel getMonsterIdentificationLabel() {
    if(monsterIdentificationLabel == null){
      monsterIdentificationLabel = new JLabel("Monster");
      monsterIdentificationLabel.setHorizontalAlignment(JLabel.CENTER);
    }
    return monsterIdentificationLabel;
  }
  
  public JPanel getMonsterImagePanel() {
    if(monsterImagePanel == null){
      monsterImagePanel = new JPanel();
      monsterImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      monsterImagePanel.setPreferredSize(new Dimension(250, 100));
      monsterImagePanel.add(getMonsterImageLabel());
    }
    return monsterImagePanel;
  }
  
  public JLabel getMonsterImageLabel() {
    if(monsterImageLabel == null){
      monsterImageLabel = new JLabel();
      monsterImageLabel.setBorder(new LineBorder(Color.black));
      monsterImageLabel.setPreferredSize(new Dimension(100, 100));
    }
    return monsterImageLabel;
  }
  
  public JPanel getMonsterAttributePanel() {
    if(monsterAttributePanel == null){
      monsterAttributePanel = new JPanel();
      monsterAttributePanel.setLayout(new GridLayout(5, 2));
      monsterAttributePanel.setPreferredSize(new Dimension(250, 230));
      
      monsterAttributePanel.add(getMonsterExpLabel());
      monsterAttributePanel.add(getMonsterExpValue());
      
      monsterAttributePanel.add(getMonsterAttackLabel());
      monsterAttributePanel.add(getMonsterAttackValue());
      
      monsterAttributePanel.add(getMonsterDefenseLabel());
      monsterAttributePanel.add(getMonsterDefenseValue());
      
      monsterAttributePanel.add(getMonsterLifeLabel());
      monsterAttributePanel.add(getMonsterLifeValue());
      
      monsterAttributePanel.add(getMonsterGoldLabel());
      monsterAttributePanel.add(getMonsterGoldValue());
    }
    return monsterAttributePanel;
  }
  
  public JLabel getMonsterLifeLabel() {
    if(monsterLifeLabel == null){
      monsterLifeLabel = new JLabel("Life:");
      monsterLifeLabel.setFont(new Font("arial", Font.BOLD, 12));
      monsterLifeLabel.setForeground(AdventureColor.BLOOD);
    }
    return monsterLifeLabel;
  }

  public JLabel getMonsterLifeValue() {
    if(monsterLifeValue == null){
      monsterLifeValue = new JLabel();
      monsterLifeValue.setFont(new Font("arial", Font.BOLD, 12));
      monsterLifeValue.setForeground(AdventureColor.BLOOD);
    }
    return monsterLifeValue;
  }

  public JLabel getMonsterAttackLabel() {
    if(monsterAttackLabel == null){
      monsterAttackLabel = new JLabel("Attack:");
    }
    return monsterAttackLabel;
  }

  public JLabel getMonsterAttackValue() {
    if(monsterAttackValue == null){
      monsterAttackValue = new JLabel();
    }
    return monsterAttackValue;
  }

  public JLabel getMonsterDefenseLabel() {
    if(monsterDefenseLabel == null){
      monsterDefenseLabel = new JLabel("Defense:");
    }
    return monsterDefenseLabel;
  }

  public JLabel getMonsterDefenseValue() {
    if(monsterDefenseValue == null){
      monsterDefenseValue = new JLabel();
    }
    return monsterDefenseValue;
  }

  public JLabel getMonsterGoldLabel() {
    if(monsterGoldLabel == null){
      monsterGoldLabel = new JLabel("Gold:");
      monsterGoldLabel.setFont(new Font("arial", Font.BOLD, 12));
      monsterGoldLabel.setForeground(AdventureColor.GOLD);
    }
    return monsterGoldLabel;
  }

  public JLabel getMonsterGoldValue() {
    if(monsterGoldValue == null){
      monsterGoldValue = new JLabel();
      monsterGoldValue.setFont(new Font("arial", Font.BOLD, 12));
      monsterGoldValue.setForeground(AdventureColor.GOLD);
    }
    return monsterGoldValue;
  }

  public JLabel getMonsterExpLabel() {
    if(monsterExpLabel == null){
      monsterExpLabel = new JLabel("Exp:");
    }
    return monsterExpLabel;
  }

  public JLabel getMonsterExpValue() {
    if(monsterExpValue == null){
      monsterExpValue = new JLabel();
    }
    return monsterExpValue;
  }

  public static void main(String[] args) {

    new BattleView().setVisible(true);
  }
  
}
