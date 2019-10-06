package com.adventure.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MapEditorView extends JFrame{

  private static final long serialVersionUID = 1L;
  
  private JPanel mainPanel;
  private BoardPanel boardPanel;
  
  private JPanel buttonsPanel;
  
  private JButton newButton;
  private JButton openButton;
  private JButton saveButton;
  private JButton exitButton;
  
  private JPanel palettePanel;
  
  private JPanel palleteNorthPanel;
  private JLabel typeLabel;
  private JComboBox typeCombo; 
  
  private JPanel palleteCenterPanel;
  private JScrollPane scrollPane;

  private JTable table;
  private DefaultTableModel floorTableModel;
  private DefaultTableModel fillTableModel;
  
  public MapEditorView() {
    initialize();
  }
  
  private void initialize(){
    this.setSize(new Dimension(1260, 860));
    this.setLocationRelativeTo(null);
    this.setContentPane(getMainPanel());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public JPanel getMainPanel() {
    if(mainPanel == null){
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(getButtonsPanel(), BorderLayout.NORTH);
      mainPanel.add(getBoardPanel(), BorderLayout.CENTER);
      mainPanel.add(getPalettePanel(), BorderLayout.EAST);
    }
    return mainPanel;
  }
  
  public BoardPanel getBoardPanel() {
    if(boardPanel == null){
      boardPanel = new BoardPanel();
      boardPanel.setBorder(new LineBorder(Color.black));
    }
    return boardPanel;
  }
  
  public void setBoardPanel(BoardPanel boardPanel) {
    this.boardPanel = boardPanel;
  }
  
  public JPanel getButtonsPanel() {
    if(buttonsPanel == null){
      buttonsPanel = new JPanel();
      buttonsPanel.setPreferredSize(new Dimension(800, 40));
      buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      buttonsPanel.setBorder(new LineBorder(Color.black));
      buttonsPanel.add(getNewButton());
      buttonsPanel.add(getOpenButton());
      buttonsPanel.add(getSaveButton());
      buttonsPanel.add(getExitButton());
    }
    return buttonsPanel;
  }
  public JPanel getPalettePanel() {
    if(palettePanel == null){
      palettePanel = new JPanel();
      palettePanel.setLayout(new BorderLayout());
      palettePanel.setPreferredSize(new Dimension(200, 600));
      palettePanel.setBorder(new LineBorder(Color.black));
      palettePanel.add(getPalleteNorthPanel(), BorderLayout.NORTH);
      palettePanel.add(getPalleteCenterPanel(), BorderLayout.CENTER);
    }
    return palettePanel;
  }
  
  public JButton getSaveButton() {
    if(saveButton == null){
      saveButton = new JButton("Save");
    }
    return saveButton;
  }
  
  public JButton getExitButton() {
    if(exitButton == null){
      exitButton = new JButton("Exit");
    }
    return exitButton;
  }
  
  public JPanel getPalleteNorthPanel() {
    if(palleteNorthPanel == null){
      palleteNorthPanel = new JPanel();
      palleteNorthPanel.setPreferredSize(new Dimension(200, 40));
      palleteNorthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      palleteNorthPanel.add(getTypeLabel());
      palleteNorthPanel.add(getTypeCombo());
    }
    return palleteNorthPanel;
  }
  
  public JLabel getTypeLabel() {
    if(typeLabel == null){
      typeLabel = new JLabel("Type:");
    }
    return typeLabel;
  }
  
  public JComboBox getTypeCombo() {
    if(typeCombo == null){
      typeCombo = new JComboBox(new String[]{"", "Floor", "Fill"});
    }
    return typeCombo;
  }
  
  public JPanel getPalleteCenterPanel() {
    if(palleteCenterPanel == null){
      palleteCenterPanel = new JPanel();
      palleteCenterPanel.setLayout(new BorderLayout());
      palleteCenterPanel.add(getScrollPane(), BorderLayout.CENTER);
    }
    return palleteCenterPanel;
  }
  
  public JScrollPane getScrollPane() {
    if(scrollPane == null){
      scrollPane = new JScrollPane();
      scrollPane.setViewportView(getTable());
    }
    return scrollPane;
  }
  
  public DefaultTableModel getFloorTableModel() {
    if(floorTableModel == null){
      floorTableModel = new DefaultTableModel();
    }
    return floorTableModel;
  }
  
  
  public JTable getTable() {
    if(table == null){
      table = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }
      };
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    return table;
  }
  
  public DefaultTableModel getFillTableModel() {
    if(fillTableModel == null){
      fillTableModel = new DefaultTableModel();
    }
    return fillTableModel;
  }
  
  public JButton getOpenButton() {
    if(openButton == null){
      openButton = new JButton("Open");
    }
    return openButton;
  }
  
  public JButton getNewButton() {
    if(newButton == null){
      newButton = new JButton("New");
    }
    return newButton;
  }
  
}
