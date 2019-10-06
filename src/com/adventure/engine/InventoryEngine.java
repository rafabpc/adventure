package com.adventure.engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.adventure.components.InventorySpace;
import com.adventure.entity.Equipment;
import com.adventure.entity.Item;
import com.adventure.entity.Loot;
import com.adventure.sessao.AdventureSession;
import com.adventure.sessao.EngineSession;
import com.adventure.type.ItemType;
import com.adventure.view.InventoryPanel;

public class InventoryEngine {

  private InventoryPanel inventoryPanel;
  private final Integer LINE_LIMIT = 5;
  
  private Integer lootCount = 0;
  
  public InventoryEngine(InventoryPanel inventoryPanel) {
    this.inventoryPanel = inventoryPanel;
    createInventory();
  }
  
  private void createInventory(){
    
    Integer capacity = AdventureSession.PLAYER.getInventory().getTotalSpace();
    
    Integer linesNumber = (capacity / LINE_LIMIT);
    Integer extraNumber = ((capacity % LINE_LIMIT) > 0 ? 1 : 0);
    linesNumber += extraNumber;
    
    
    inventoryPanel.setLayout(new BorderLayout());
    inventoryPanel.setMatrix(new InventorySpace[linesNumber][LINE_LIMIT]);
    
    for(Integer x=0; x<linesNumber; x++){
      for(Integer y=0; y<LINE_LIMIT;y++){
        
        InventorySpace inventorySpace = new InventorySpace();
        inventorySpace.setLine(x);
        inventorySpace.setColumn(y);
        
        if(lootCount < AdventureSession.PLAYER.getInventory().getOccupiedSpace()){
          Loot loot = AdventureSession.PLAYER.getInventory().getLoots().get(lootCount);
          inventorySpace.setLoot(loot);
          inventorySpace.setText(loot.getName());
          if(loot instanceof Equipment){
            Equipment equip = (Equipment) loot;
            inventorySpace.setToolTipText("<html> " + loot.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
          }else if(loot instanceof Item){
            Item item = (Item) loot;
            inventorySpace.setToolTipText("<html> " + loot.getName() + " <br/> Bonus: " + item.getBonus() +"</html>");
          }
          
          lootCount++;
        }
        
        inventoryPanel.getMatrix()[x][y] = inventorySpace;
        
      }
      
    }
    
    populateInventory();
    
  }
  
  private void populateInventory(){
    Integer capacity = AdventureSession.PLAYER.getInventory().getTotalSpace();
    Integer lineNumber = (capacity / LINE_LIMIT);
    Integer extraNumber = ((capacity % LINE_LIMIT) > 0 ? 1 : 0);
    lineNumber += extraNumber;
    
    this.inventoryPanel.removeAll();
    
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
    panel.setBackground(Color.yellow);
    
    for(Integer x=0; x<lineNumber; x++){
      
      for(Integer y=0; y<LINE_LIMIT;y++){
        if(extraNumber == 0){
          createInventorySpaceEvent(inventoryPanel.getMatrix()[x][y]);
          panel.add(inventoryPanel.getMatrix()[x][y]);
        }
        else{
          if(x < (lineNumber - 1)){
            createInventorySpaceEvent(inventoryPanel.getMatrix()[x][y]);
            panel.add(inventoryPanel.getMatrix()[x][y]);
          }
          else if(x == (lineNumber -1) && y <= ((capacity % LINE_LIMIT)-1)){
            createInventorySpaceEvent(inventoryPanel.getMatrix()[x][y]);
            panel.add(inventoryPanel.getMatrix()[x][y]);          
          }
        }
      }
      this.inventoryPanel.add(panel, BorderLayout.CENTER);
    }
    
    lootCount = 0;
    inventoryPanel.revalidate();
    inventoryPanel.repaint();
  }
  
  private void createInventorySpaceEvent(final InventorySpace inventorySpace){
    inventorySpace.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){

          if(inventorySpace.getLoot() != null && inventorySpace.getText() != null){
            Integer op = JOptionPane.showOptionDialog(null, "What do you want to do with this item ("+ inventorySpace.getLoot().getName() +") ?", "Inventory", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Equip/Use", "Sell ( " + inventorySpace.getLoot().getSellPrice() + " )", "Throw away", "Cancel"}, 0);
            
            if(inventorySpace.getLoot() instanceof Equipment){              

              if(op == 0){
                if(isEquipped((Equipment) inventorySpace.getLoot())){
                  JOptionPane.showMessageDialog(null, "You must remove what is equipped first!");
                }else{
                  Loot loot = inventorySpace.getLoot();
                  equip(loot);
                  removeItem(inventorySpace, loot);
                }
              }
              
            }
            else if(inventorySpace.getLoot() instanceof Item){

              if(op == 0){
                if(((Item)inventorySpace.getLoot()).getType() == ItemType.LIFE_POTION){
                  usePotion(inventorySpace, (Item)inventorySpace.getLoot());
                }
                
                else if(((Item)inventorySpace.getLoot()).getType() == ItemType.BAG_EXPANDER){
                  useBagExpander(inventorySpace, (Item)inventorySpace.getLoot());
                }
                
                else if(((Item)inventorySpace.getLoot()).getType() == ItemType.ESCAPE){
                  useEscape(inventorySpace, (Item)inventorySpace.getLoot());
                }
              }
            }
            

            if(op == 1){
              AdventureSession.PLAYER.setGold(AdventureSession.PLAYER.getGold() + inventorySpace.getLoot().getSellPrice());
              removeItem(inventorySpace, inventorySpace.getLoot());
              EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
              if(EngineSession.getBatalhaEngine() != null){
                EngineSession.getBatalhaEngine().loadAttributes();
              }
            }

            else if(op == 2){
              removeItem(inventorySpace, inventorySpace.getLoot());
            }
          }
        }
      }
    });
  }
  
  private void equip(Loot equip){
    AdventureSession.PLAYER.getEquippedEquipments().add((Equipment) equip);
    EngineSession.EQUIPMENT_ENGINE.reloadEquipments();
    EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
  }
  
  private boolean isEquipped(Equipment equip){
    for(Equipment equipped : AdventureSession.PLAYER.getEquippedEquipments()){
      if(equipped.getType() == equip.getType()) return true;
    }
    return false;
  }
  
  public void usePotion(InventorySpace inventorySpace, Item item){
    if(AdventureSession.PLAYER.getCurrentlyLife() == AdventureSession.PLAYER.getMaxLife()){
      JOptionPane.showMessageDialog(EngineSession.getBatalhaEngine() == null ? null : EngineSession.getBatalhaEngine().getBattleView(), "Your life is full!");
    }else{
      Integer newCurrentlyLife = (item.getBonus() + AdventureSession.PLAYER.getCurrentlyLife()) > AdventureSession.PLAYER.getMaxLife() ? AdventureSession.PLAYER.getMaxLife() : (item.getBonus() + AdventureSession.PLAYER.getCurrentlyLife());
      AdventureSession.PLAYER.setCurrentlyLife(newCurrentlyLife);
      removeItem(inventorySpace, item);
      EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
      
      if(EngineSession.getBatalhaEngine() != null){
        EngineSession.getBatalhaEngine().loadAttributes();
        EngineSession.INVENTORY_ENGINE.repopulateInventory();
        if(EngineSession.getBatalhaEngine() != null)EngineSession.getBatalhaEngine().getInventoryEngine().repopulateInventory();
      }
    }
  }
  
  private void useBagExpander(InventorySpace inventorySpace, Item item){
    if(EngineSession.getBatalhaEngine() == null){
      int op = JOptionPane.showConfirmDialog(null, "Do you want to expand your inventory with 1 slot?");
      if(op == 0){
        AdventureSession.PLAYER.getInventory().setTotalSpace(AdventureSession.PLAYER.getInventory().getTotalSpace() + 1);
        AdventureSession.PLAYER.getInventory().setEmptySpace(AdventureSession.PLAYER.getInventory().getEmptySpace() + 1);
        removeItem(inventorySpace, item);
      }      
    }else{
      JOptionPane.showMessageDialog(EngineSession.getBatalhaEngine().getBattleView(), "You only can use this item when out of battles.");
    }
  }
  
  public void useEscape(InventorySpace inventorySpace, Item item){
    
    if(EngineSession.getBatalhaEngine() == null){
      int op = JOptionPane.showConfirmDialog(null, "Do you want to return to the city?");
      if(op == 0){
        removeItem(inventorySpace, item);
        EngineSession.BOARD_ENGINE.voltarParaCidade();
      }
    }else{
      int op = JOptionPane.showConfirmDialog(EngineSession.getBatalhaEngine().getBattleView(), "Do you really want to escape this battle?");
      if(op == 0){
        EngineSession.getBatalhaEngine().getBattleView().dispose();
        removeItem(inventorySpace, item);
        EngineSession.BATTLE_ENGINE(null);
      }
    }
  }
  
  public Boolean addItem(Loot loot){
    
    if(AdventureSession.PLAYER.getInventory().getLoots().size() >= AdventureSession.PLAYER.getInventory().getTotalSpace()){
      return false;
    }else{
      AdventureSession.PLAYER.getInventory().getLoots().add(loot);
      AdventureSession.PLAYER.getInventory().setOccupiedSpace(AdventureSession.PLAYER.getInventory().getOccupiedSpace() + 1);
      AdventureSession.PLAYER.getInventory().setEmptySpace(AdventureSession.PLAYER.getInventory().getEmptySpace() - 1);
      
      repopulateInventory();

      return true;
    }
    
  }
  
  public void removeItem(InventorySpace inventorySpace, Loot loot){    
    AdventureSession.PLAYER.getInventory().getLoots().remove(loot);
    AdventureSession.PLAYER.getInventory().setOccupiedSpace(AdventureSession.PLAYER.getInventory().getOccupiedSpace() - 1);
    AdventureSession.PLAYER.getInventory().setEmptySpace(AdventureSession.PLAYER.getInventory().getEmptySpace() + 1);
    
    if(inventorySpace != null){
      inventorySpace.setLoot(null);
      inventorySpace.setText(null);      
    }
    
    repopulateInventory();
  }
  
  public void repopulateInventory(){
    createInventory();
    EngineSession.INVENTORY_ENGINE.createInventory();
  }
  
}
