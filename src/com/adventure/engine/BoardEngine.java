package com.adventure.engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.adventure.components.BoardSpace;
import com.adventure.entity.Player;
import com.adventure.entity.Loot;
import com.adventure.entity.Monster;
import com.adventure.scripts.PlayerScript;
import com.adventure.sessao.AdventureSession;
import com.adventure.sessao.EngineSession;
import com.adventure.type.FillType;
import com.adventure.type.FloorType;
import com.adventure.type.LootType;
import com.adventure.type.MonsterType;
import com.adventure.type.StoreType;
import com.adventure.utils.RandomGold;
import com.adventure.utils.RandomLoot;
import com.adventure.view.AdventureView;
import com.adventure.view.StoreView;
import com.thoughtworks.xstream.XStream;

public class BoardEngine {

  private AdventureView gameScreen;
  private Integer playerLine;
  private Integer playerColumn;
  private File map;
  private File cityMap;
  
  public BoardEngine(AdventureView gameScreen, File map) {
    this.gameScreen = gameScreen;
    this.map = map;
    this.cityMap = new File(System.getProperty("user.dir") + "/maps/City.map");
    
    try {
      createBoard();
      activateBoardMoves();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private void createBoard() throws IOException{
    FileReader reader = new FileReader(this.map);
    @SuppressWarnings("resource")
    BufferedReader buffer = new BufferedReader(reader);
    
    String data = null;
    int lin = 0;
    int col = 0;
    
    while((data = buffer.readLine()) != null){
      String cols[] = data.split(";");
      
      for(col=0; col<20; col++){
        
        BoardSpace boardSpace = new BoardSpace();    
        boardSpace.setFloorType(FloorType.getTypeById(cols[col].toUpperCase()));
        boardSpace.setBackground(FloorType.getColorById(cols[col].toUpperCase()));
        boardSpace.setFillType(FillType.getTypeById(cols[col].toUpperCase()));
        String fillType = FillType.getDescricaoById(cols[col].toUpperCase());        
        
        if(fillType.equals("Player")){
          playerLine = lin;
          playerColumn = col;
          boardSpace.setText(AdventureSession.PLAYER.getName());          
        }else{
          boardSpace.setText(fillType.equals(FillType.MONSTER.getDescription()) ? MonsterType.getDescricaoById(cols[col].toUpperCase()) : fillType);
          boardSpace.setCreature(AdventureSession.getMonster(MonsterType.getTypeById(cols[col].toUpperCase())));
        }
        
        
        boardSpace.setLine(lin);
        boardSpace.setColumn(col);
        
        gameScreen.getBoardPanel().getMatrix()[lin][col] = boardSpace;
        
      }
      
      lin++;
    }
    
    populateBoard();
  }
  
  private void populateBoard(){
    this.gameScreen.getBoardPanel().removeAll();
    
    for(int x=0; x<20; x++){
      for(int y=0; y<20; y++){
        this.gameScreen.getBoardPanel().add(gameScreen.getBoardPanel().getMatrix()[x][y]);
      }
    }
    
    gameScreen.getBoardPanel().revalidate();
    gameScreen.getBoardPanel().repaint();
  }
  
  private void activateBoardMoves(){
    gameScreen.addKeyListener(new KeyAdapter() {
      
      @Override
      public void keyPressed(KeyEvent e) {
        
        BoardSpace playerBoardSpace = gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn];
        
        //UP
        if(e.getKeyCode() == 38){
          BoardSpace moveBoardSpace = gameScreen.getBoardPanel().getMatrix()[playerLine-1][playerColumn];
          if(canMove(moveBoardSpace)){
            
            Color colorPlayerBoardSpace = playerBoardSpace.getBackground();
            Color colorMoveBoardSpace = moveBoardSpace.getBackground();
            playerBoardSpace.setBackground(colorMoveBoardSpace);
            moveBoardSpace.setBackground(colorPlayerBoardSpace);
            
            gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn] = moveBoardSpace;
            gameScreen.getBoardPanel().getMatrix()[playerLine-1][playerColumn] = playerBoardSpace;
            
            playerLine = playerLine - 1;
            
            populateBoard();            
          }
        }
        
        //DOWN
        if(e.getKeyCode() == 40){
          BoardSpace moveBoardSpace = gameScreen.getBoardPanel().getMatrix()[playerLine+1][playerColumn];
          if(canMove(moveBoardSpace)){
            Color colorPlayerBoardSpace = playerBoardSpace.getBackground();
            Color colorMoveBoardSpace = moveBoardSpace.getBackground();
            playerBoardSpace.setBackground(colorMoveBoardSpace);
            moveBoardSpace.setBackground(colorPlayerBoardSpace);
            
            gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn] = moveBoardSpace;
            gameScreen.getBoardPanel().getMatrix()[playerLine+1][playerColumn] = playerBoardSpace;
            
            playerLine = playerLine + 1;
            
            populateBoard();
          }
        }
        
        //RIGHT
        if(e.getKeyCode() == 39){
          BoardSpace moveBoardSpace = gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn+1];
          if(canMove(moveBoardSpace)){
            Color colorPlayerBoardSpace = playerBoardSpace.getBackground();
            Color colorMoveBoardSpace = moveBoardSpace.getBackground();
            playerBoardSpace.setBackground(colorMoveBoardSpace);
            moveBoardSpace.setBackground(colorPlayerBoardSpace);
            
            gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn] = moveBoardSpace;
            gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn+1] = playerBoardSpace;
            
            playerColumn = playerColumn + 1;
            
            populateBoard();            
          }
          
        }
        
        //LEFT
        if(e.getKeyCode() == 37){
          BoardSpace moveBoardSpace = gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn-1];
          if(canMove(moveBoardSpace)){
            Color colorPlayerBoardSpace = playerBoardSpace.getBackground();
            Color colorMoveBoardSpace = moveBoardSpace.getBackground();
            playerBoardSpace.setBackground(colorMoveBoardSpace);
            moveBoardSpace.setBackground(colorPlayerBoardSpace);
            
            gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn] = moveBoardSpace;
            gameScreen.getBoardPanel().getMatrix()[playerLine][playerColumn-1] = playerBoardSpace;
            
            playerColumn = playerColumn - 1;
            
            populateBoard();
          }
        }
        
      }
      
    });
  }
  
  private boolean canMove(BoardSpace moveBoardSpace){
    if(moveBoardSpace.getFloorType() == FloorType.GRASS || moveBoardSpace.getFloorType() == FloorType.GROUND){
      if(moveBoardSpace.getFillType() == null){
        return true;
      }else{
        return executeFillEvent(moveBoardSpace);
      }
    }else{
      return false;
    }
  }
  
  private boolean executeFillEvent(BoardSpace moveBoardSpace){
    
    if(moveBoardSpace.getFillType() == FillType.LOGOUT){
      int op = JOptionPane.showConfirmDialog(gameScreen, "Do you really want to leave this game?");
      if(op == 0){
        System.exit(0);
      }else{
        return false;
      }
    }
    
    if(moveBoardSpace.getFillType() == FillType.ITENS_STORE){
      String[] columns = new String[]{"Item", "Price", "Bonus", ""};
      StoreView storeView = new StoreView(columns);
      storeView.setLocationRelativeTo(gameScreen);
      new StoreEngine(storeView, StoreType.ITEM, columns.length);
      storeView.setVisible(true);
    }
    
    if(moveBoardSpace.getFillType() == FillType.EQUIPMENTS_STORE){
      String[] columns = new String[]{"Item", "Price", "Attack", "Defense", ""};
      StoreView storeView = new StoreView(columns);
      storeView.setLocationRelativeTo(gameScreen);
      new StoreEngine(storeView, StoreType.EQUIPMENT, columns.length);
      storeView.setVisible(true);
    }
    
    if(moveBoardSpace.getFillType() == FillType.PLAY){
      chooseMap();
    }
    
    if(moveBoardSpace.getFillType() == FillType.SAVE){
      Integer op = JOptionPane.showConfirmDialog(gameScreen, "Do you want to save the game?");
      if(op == 0){
        try{
          XStream xstream = new XStream();
          String xml = xstream.toXML(AdventureSession.PLAYER);
          
          File file = new File(System.getProperty("user.dir") + "/saves/" + AdventureSession.PLAYER.getName() + ".adventure");
          
          if(file.exists()){
            Integer op2 = JOptionPane.showConfirmDialog(gameScreen, "This game is already existing, do you want to override it?");
            if(op2 == 0){
              FileWriter out = new FileWriter(file);
              BufferedWriter writer = new BufferedWriter(out);
              writer.append(xml);
              writer.flush();
              writer.close();              
              JOptionPane.showMessageDialog(gameScreen, "Game saved!");
            }
          }else{
            FileWriter out = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(out);
            writer.append(xml);
            writer.flush();
            writer.close();              
            JOptionPane.showMessageDialog(gameScreen, "Game saved!");
          }
        }catch(IOException io){
          JOptionPane.showMessageDialog(gameScreen, "It wasn't possible to save your game.");
        }        
      }  
    }
    
    if(moveBoardSpace.getFillType() == FillType.MENU){
      int op = JOptionPane.showConfirmDialog(gameScreen, "Do you want to return the the menu? Your game won't be saved.");
      if(op == 0){
        gameScreen.getProfilePanel().setVisible(false);
        this.map = new File(System.getProperty("user.dir") + "/maps/Menu.map");
        try {
          PlayerScript.reStart();
          createBoard();
          EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
          EngineSession.EQUIPMENT_ENGINE.reloadEquipments();
          EngineSession.INVENTORY_ENGINE.repopulateInventory();
        } catch (IOException e) {
          JOptionPane.showMessageDialog(gameScreen, "Not possible to return to the menu!");
        }
      }
      
    }
    
    if(moveBoardSpace.getFillType() == FillType.NEW_GAME){
      
      String name = null;
      do{
        name = JOptionPane.showInputDialog("Inform your name:");
      }while(name == null);
      
      AdventureSession.PLAYER.setName(name);
      
      try {
        this.map = new File(System.getProperty("user.dir") + "/maps/City.map");
        createBoard();
        this.gameScreen.getProfilePanel().setVisible(true);
        JOptionPane.showMessageDialog(gameScreen, "Game started!");
      } catch (IOException e) {
        this.map = new File(System.getProperty("user.dir") + "/maps/Menu.map");
        JOptionPane.showMessageDialog(gameScreen, "Your game cannot be started!");
      }      
    }
    
    if(moveBoardSpace.getFillType() == FillType.LOAD){
      JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/saves/");
      fileChooser.showOpenDialog(gameScreen);
      File file = fileChooser.getSelectedFile();
      
      if(file != null){
        int op = JOptionPane.showConfirmDialog(gameScreen, "Do you want to load the game: "+ file.getName() + " ?");
        if(op == 0){
          
          XStream xstream = new XStream();
          AdventureSession.PLAYER = (Player) xstream.fromXML(file);
          EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
          EngineSession.EQUIPMENT_ENGINE.reloadEquipments();
          EngineSession.INVENTORY_ENGINE.repopulateInventory();
          
          try {
            this.map = new File(System.getProperty("user.dir") + "/maps/City.map");
            createBoard();
            this.gameScreen.getProfilePanel().setVisible(true);
            JOptionPane.showMessageDialog(gameScreen, "Game loaded!");
          } catch (IOException e) {
            this.map = new File(System.getProperty("user.dir") + "/maps/Menu.map");
            JOptionPane.showMessageDialog(gameScreen, "Not possible to load your game!");
          }
          
        }
      }
      
    }
    
    if(moveBoardSpace.getFillType() == FillType.EXIT){
      int op = JOptionPane.showConfirmDialog(gameScreen, "Do you want to go back to the city?");
      if(op == 0){
        voltarParaCidade(); 
      }else{
        return false;
      }
    }
    
    if(moveBoardSpace.getFillType() == FillType.MONSTER){
      int op = JOptionPane.showConfirmDialog(gameScreen, "Do you want to have a battle with this " +moveBoardSpace.getText()+ "?");
      if(op == 0){
        new BattleEngine((Monster)moveBoardSpace.getCreature(), gameScreen, moveBoardSpace);
        if(EngineSession.getBatalhaEngine() == null){
          return true;          
        }else{
          return false;
        }  
      }else{
        return false;
      }
    }
    
    if(moveBoardSpace.getFillType() == FillType.GOLD_CHEST){
      Integer gold = RandomGold.randomGold();
      JOptionPane.showMessageDialog(gameScreen, "You found " + gold + " gold.");
      AdventureSession.PLAYER.setGold(AdventureSession.PLAYER.getGold() + gold);
      EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
      removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.COPPER_EQUIPMENT_CHEST){
      foundLoot(gameScreen, RandomLoot.randomEquipment(LootType.COPPER));
      removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.SILVER_EQUIPMENT_CHEST){
      foundLoot(gameScreen, RandomLoot.randomEquipment(LootType.SILVER));
      removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.GOLD_EQUIPMENT_CHEST){
      foundLoot(gameScreen, RandomLoot.randomEquipment(LootType.GOLD));
      removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.PLATINUM_EQUIPMENT_CHEST){
        foundLoot(gameScreen, RandomLoot.randomEquipment(LootType.PLATINUM));
        removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.DIAMOND_EQUIPMENT_CHEST){
        foundLoot(gameScreen, RandomLoot.randomEquipment(LootType.DIAMOND));
        removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.LEGENDARY_EQUIPMENT_CHEST){
        foundLoot(gameScreen, RandomLoot.randomEquipment(LootType.LEGENDARY));
        removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.COPPER_ITEM_CHEST){
      foundLoot(gameScreen, RandomLoot.randomItem(LootType.COPPER));
      removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.SILVER_ITEM_CHEST){
      foundLoot(gameScreen, RandomLoot.randomItem(LootType.SILVER));
      removeFill(moveBoardSpace);
    }
    
    if(moveBoardSpace.getFillType() == FillType.GOLD_ITEM_CHEST){
      foundLoot(gameScreen, RandomLoot.randomItem(LootType.GOLD));
      removeFill(moveBoardSpace);
    }
    
    return false;
  }
  
  public void foundLoot(Component reference, Loot loot){
    if(loot != null){
      
      Integer op = JOptionPane.showOptionDialog(reference, "You found " + loot.getName() + "\n What do you want to do?", "Loot", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Take", "Sell ( " + loot.getSellPrice() + " )", "Throw away"}, 0);
      if(op == 0){
        Boolean took = EngineSession.INVENTORY_ENGINE.addItem(loot);
        if(took){
          if(EngineSession.getBatalhaEngine() != null) EngineSession.getBatalhaEngine().getInventoryEngine().repopulateInventory();            
        }else{
          JOptionPane.showMessageDialog(reference, "Your inventory is full, try selling some items.\n This item " + loot.getName() + " will be sold by " + loot.getSellPrice() + " gold.");
          AdventureSession.PLAYER.setGold(AdventureSession.PLAYER.getGold() + loot.getSellPrice());
        }
      }
      else if(op == 1){
        AdventureSession.PLAYER.setGold(AdventureSession.PLAYER.getGold() + loot.getSellPrice());
      }
      
    }
  }
  
  public void voltarParaCidade(){
    this.map = cityMap;
    try {
      createBoard();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private boolean executeFloorEvent(BoardSpace boardSpace){
    return false;
  }
  
  private File chooseMap(){
    final String directory = System.getProperty("user.dir") + "/maps/";
    
    final JList<String> listMaps = new JList<String>(new DefaultListModel<String>());
    listMaps.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    final JDialog jDialog = new JDialog();
    jDialog.setSize(300, 300);
    jDialog.setLocationRelativeTo(gameScreen);
    jDialog.setContentPane(new JScrollPane(listMaps));
    
    File file = new File(directory);
    for(File map : file.listFiles()){
      if(! map.getName().contains("City") && ! map.getName().contains("Menu")) ((DefaultListModel<String>)listMaps.getModel()).addElement(map.getName());  
    }
    
    listMaps.addMouseListener(new MouseAdapter() {
      
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e) {
      
        if(e.getClickCount() == 2){
          String filename = listMaps.getModel().getElementAt(listMaps.getSelectedIndex());
          String filepath = directory + filename;
          map = new File(filepath);
          jDialog.dispose();
          
          try {
            createBoard();
          } catch (IOException ex) {
            ex.printStackTrace();
          }
          
        }
        
      };
    });  
    
    listMaps.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 10){
          String filename = listMaps.getModel().getElementAt(listMaps.getSelectedIndex());
          String filepath = directory + filename;
          map = new File(filepath);
          jDialog.dispose();
          
          try {
            createBoard();
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      }
    });
    
    jDialog.setVisible(true);
    
    return map;
  }
  
  public void removeFill(BoardSpace boardSpace){
    boardSpace.setFillType(null);
    boardSpace.setText("");
    boardSpace.setCode(FloorType.GRASS.getId());
    boardSpace.setFloorType(FloorType.GRASS);
    gameScreen.getBoardPanel().getMatrix()[boardSpace.getLine()][boardSpace.getColumn()] = boardSpace;
    gameScreen.revalidate();
    gameScreen.repaint();
  }
  
}
