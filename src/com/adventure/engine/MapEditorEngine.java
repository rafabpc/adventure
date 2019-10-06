package com.adventure.engine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.adventure.components.BoardSpace;
import com.adventure.type.FillType;
import com.adventure.type.FloorType;
import com.adventure.type.MonsterType;
import com.adventure.view.MapEditorView;

public class MapEditorEngine {

  private MapEditorView mapEditorView;
  private BoardSpace selectedBoardSpace;
  
  private String fileName;
  
  public MapEditorEngine(MapEditorView mapEditorView) {
    this.mapEditorView = mapEditorView;
    this.mapEditorView.setTitle("unamed.map");
    this.fileName = "";
    
    
    createEmptyBoard();
    populateBoard();
    createFillTableModel();
    createFloorTableModel();
    createEvents();
  }
  
  private void populateBoardWithMap(File map) throws IOException{
    FileReader reader = new FileReader(map);
    @SuppressWarnings("resource")
    BufferedReader buffer = new BufferedReader(reader);
    
    String data = null;
    int lin = 0;
    int col = 0;
    
    while((data = buffer.readLine()) != null){
      String cols[] = data.split(";");
      
      for(col=0; col<20; col++){
        BoardSpace boardSpace = mapEditorView.getBoardPanel().getMatrix()[lin][col];
        
        boardSpace.setCode(cols[col].toUpperCase());
        boardSpace.setFloorType(FloorType.getTypeById(cols[col].toUpperCase()));
        boardSpace.setBackground(FloorType.getColorById(cols[col].toUpperCase()));
        boardSpace.setFillType(FillType.getTypeById(cols[col].toUpperCase()));
        String fillType = FillType.getDescricaoById(cols[col].toUpperCase());  
        
        boardSpace.setText(fillType.equals(FillType.MONSTER.getDescription()) ? MonsterType.getDescricaoById(cols[col].toUpperCase()) : fillType);
        
        
        mapEditorView.getBoardPanel().getMatrix()[lin][col] = boardSpace;
        
      }
      lin++;
    }
   
  }
  
  private void createEmptyBoard(){    
    for(int lin=0; lin<20; lin++){
      for(int col=0; col<20; col++){
        
        final BoardSpace boardSpace = new BoardSpace();    
        boardSpace.setFloorType(FloorType.GRASS);
        boardSpace.setBackground(FloorType.getColorById(FloorType.GRASS.getId()));
        boardSpace.setCode(FloorType.GRASS.getId());
        
        boardSpace.setLine(lin);
        boardSpace.setColumn(col);
        
        boardSpace.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if(selectedBoardSpace == null){
              boardSpace.setBorder(new LineBorder(Color.BLUE, 3));
              selectedBoardSpace = boardSpace;
            }else{
              selectedBoardSpace.setBorder(boardSpace.getBorder());
              boardSpace.setBorder(new LineBorder(Color.BLUE, 3));
              selectedBoardSpace = boardSpace;
            }
            
            if(e.getButton() == MouseEvent.BUTTON3){
              if(mapEditorView.getTable().getSelectedRow() > -1){
                fillBoardSpace("" + mapEditorView.getTable().getValueAt(mapEditorView.getTable().getSelectedRow(), 0));                
              }
            }
          }
        });
        
        mapEditorView.getBoardPanel().getMatrix()[lin][col] = boardSpace;
      }      
    }
  }
  
  private void clearBoard(){
    for(BoardSpace[] boardSpaces : mapEditorView.getBoardPanel().getMatrix()){
      for(BoardSpace boardSpace : boardSpaces){
        boardSpace.setFloorType(FloorType.GRASS);
        boardSpace.setBackground(FloorType.getColorById(FloorType.GRASS.getId()));
        boardSpace.setCode(FloorType.GRASS.getId());
        boardSpace.setText("");
      }
    }
    
    mapEditorView.revalidate();
    mapEditorView.repaint();
  }
  
  private void populateBoard(){
    for(int x=0; x<20; x++){
      for(int y=0; y<20; y++){
        mapEditorView.getBoardPanel().add(mapEditorView.getBoardPanel().getMatrix()[x][y]);
      }
    }
    
    mapEditorView.getBoardPanel().revalidate();
    mapEditorView.getBoardPanel().repaint();
  }
  
  private void createEvents(){
    this.mapEditorView.getTypeCombo().addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {  
        if(mapEditorView.getTypeCombo().getSelectedItem().toString().equals("Fill")){
          mapEditorView.getTable().setModel(mapEditorView.getFillTableModel());
          mapEditorView.getScrollPane().revalidate();
          mapEditorView.getScrollPane().repaint();
        }
        
        else if(mapEditorView.getTypeCombo().getSelectedItem().toString().equals("Floor")){
          mapEditorView.getTable().setModel(mapEditorView.getFloorTableModel());
          mapEditorView.getScrollPane().revalidate();
          mapEditorView.getScrollPane().repaint();
        }
        
        else{
          mapEditorView.getTable().setModel(new DefaultTableModel());
          mapEditorView.getScrollPane().revalidate();
          mapEditorView.getScrollPane().repaint();
        }
        
      }
    });
    
    this.mapEditorView.getTable().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        
        if(e.getClickCount() == 2){
          if(mapEditorView.getTable().getSelectedRow() > -1){
            fillBoardSpace("" + mapEditorView.getTable().getValueAt(mapEditorView.getTable().getSelectedRow(), 0));            
          }
        }
        
      }
    });
    
    this.mapEditorView.getSaveButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Boolean save = false;  
        Boolean isNew = true;
        Boolean endWhile = false;
        
        do{
          try {
            
          if(fileName.equals("")){
            isNew = true;
            fileName = JOptionPane.showInputDialog("Inform the map's name:");
          }else{
            isNew = false;
          }
          
          File file = new File(System.getProperty("user.dir") + "/maps/" + fileName + ".map");
          
          if(file.exists() && isNew){
            int op = JOptionPane.showConfirmDialog(mapEditorView, "The map already exists, do you want to overrid it?");
            if(op == 0){
              save = true;
            }else{
              save = false;
              endWhile = true;
            }
          }else{
            save = true;
          }
            
          if(save == true){
            FileWriter out = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(out);
            
            for(BoardSpace[] boardSpaces : mapEditorView.getBoardPanel().getMatrix()){
              for(BoardSpace boardSpace : boardSpaces){
                writer.append(boardSpace.getCode() + ";");
              }
              writer.newLine();
            }
            
            writer.flush();
            writer.close();
            
            mapEditorView.setTitle(fileName + ".map");
            
            JOptionPane.showMessageDialog(mapEditorView, "Map saved!");
          }
          
          if(endWhile) save = true;
          
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(mapEditorView, "It wasn't possible to save the map.");
        }
          
        }while(save == false && endWhile == false);
        
      }
    });
    
    this.mapEditorView.getNewButton().addActionListener(new ActionListener() {      
      @Override
      public void actionPerformed(ActionEvent e) {
        fileName = "";
        mapEditorView.setTitle("unamed.map");
        clearBoard();
      }
    });
    
    this.mapEditorView.getExitButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    
    this.mapEditorView.getOpenButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/maps/");
        fileChooser.showOpenDialog(mapEditorView);
        File file = fileChooser.getSelectedFile();
        try {
          mapEditorView.setTitle(file.getName());
          populateBoardWithMap(file);
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(mapEditorView, "It wasn't possible to load the map!");
        }
      }
    });
    
  }
  
  private void fillBoardSpace(String id){
    selectedBoardSpace.setCode(id);
    selectedBoardSpace.setFloorType(FloorType.getTypeById(id.toUpperCase()));
    selectedBoardSpace.setBackground(FloorType.getColorById(id.toUpperCase()));
    selectedBoardSpace.setFillType(FillType.getTypeById(id.toUpperCase()));
    String fillType = FillType.getDescricaoById(id.toUpperCase());        
    
    if(fillType.equals(FillType.PLAYER.getDescription())){
      selectedBoardSpace.setText(FillType.PLAYER.getDescription());          
    }else{
      selectedBoardSpace.setText(fillType.equals(FillType.MONSTER.getDescription()) ? MonsterType.getDescricaoById(id.toUpperCase()) : fillType);
    }
    
    
    mapEditorView.getBoardPanel().getMatrix()[selectedBoardSpace.getLine()][selectedBoardSpace.getColumn()] = selectedBoardSpace;
  }
  
  private void createFillTableModel(){
    String columns[] = new String[]{"Code", "Description"};
    
    for(String column : columns){
      this.mapEditorView.getFillTableModel().addColumn(column);      
    }
    
    for(FillType fill : FillType.values()){
      if(fill.getId().equals(FillType.MONSTER.getId())){
        for(MonsterType monster : MonsterType.values()){
          this.mapEditorView.getFillTableModel().addRow(new String[]{monster.getId(), monster.getDescription()});
        }
      }else{
        this.mapEditorView.getFillTableModel().addRow(new String[]{fill.getId(), fill.getDescription()});        
      }
    }
    
  }
  
  
  private void createFloorTableModel(){
    String columns[] = new String[]{"Code", "Description", "Color"};
    
    for(String column : columns){
      this.mapEditorView.getFloorTableModel().addColumn(column);      
    }
    
    for(FloorType floor : FloorType.values()){
      this.mapEditorView.getFloorTableModel().addRow(new Object[]{floor.getId(), floor.toString(), floor.getColor()});
    }
    
  }
}
