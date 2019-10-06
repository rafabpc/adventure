package com.adventure.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StoreView extends JDialog{

  private static final long serialVersionUID = 1L;
  
  private JPanel mainPanel;
  private JPanel buttonPanel;
  private JPanel storePanel;
  
  private JScrollPane scrollPane;
  private JTable storeTable;
  private DefaultTableModel tableModel;
  private JButton buyButton;
  private JButton exitButton;
  
  private String columns[];  
  
  public StoreView(String columns[]) {
    this.columns = columns;
    initialize();
  }
  
  private void initialize(){
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setSize(new Dimension(400, 400));
    this.setContentPane(getMainPanel());
  }
  
  public JPanel getMainPanel() {
    if(mainPanel == null){
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(getButtonPanel(), BorderLayout.NORTH);
      mainPanel.add(getStorePanel(), BorderLayout.CENTER);
    }
    return mainPanel;
  }
  
  public JPanel getButtonPanel() {
    if(buttonPanel == null){
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      buttonPanel.setPreferredSize(new Dimension(400, 30));
      buttonPanel.add(getBuyButton());
      buttonPanel.add(getExitButton());
    }
    return buttonPanel;
  }
  
  public JPanel getStorePanel() {
    if(storePanel == null){
      storePanel = new JPanel();
      storePanel.setLayout(new BorderLayout());
      storePanel.setPreferredSize(new Dimension(400 , 340));
      storePanel.add(getScrollPane(), BorderLayout.CENTER);
    }
    return storePanel;
  }
  
  public JButton getBuyButton() {
    if(buyButton == null){
      buyButton = new JButton("Buy");
      buyButton.setPreferredSize(new Dimension(100, 20));
    }
    return buyButton;
  }
  
  public JButton getExitButton() {
    if(exitButton == null){
      exitButton = new JButton("Exit");
      exitButton.setPreferredSize(new Dimension(100, 20));
    }
    return exitButton;
  }
  
  public JScrollPane getScrollPane() {
    if(scrollPane == null){
      scrollPane = new JScrollPane();
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setViewportView(getStoreTable());
    }
    return scrollPane;
  }
  
  public JTable getStoreTable() {
    if(storeTable == null){
      storeTable = new JTable();
      storeTable.setModel(getTableModel());
      storeTable.setRowSelectionAllowed(true);
      storeTable.getColumnModel().getColumn(columns.length-1).setMaxWidth(0);
      storeTable.getColumnModel().getColumn(columns.length-1).setMinWidth(0);
      storeTable.getTableHeader().getColumnModel().getColumn(columns.length-1).setMaxWidth(0);  
      storeTable.getTableHeader().getColumnModel().getColumn(columns.length-1).setMinWidth(0);  
    }
    return storeTable;
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
}
