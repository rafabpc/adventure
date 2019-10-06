package com.adventure.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.adventure.entity.Equipment;
import com.adventure.entity.Item;
import com.adventure.entity.Loot;
import com.adventure.sessao.AdventureSession;
import com.adventure.sessao.EngineSession;
import com.adventure.type.StoreType;
import com.adventure.view.StoreView;

public class StoreEngine {

  private StoreView storeView;
  
  public StoreEngine(final StoreView storeView, StoreType storeType, final Integer columnLoot) {
    this.storeView = storeView;
    
    if(storeType == StoreType.ITEM){
      for(Loot loot : AdventureSession.LOOTS){
        if(loot instanceof Item){
          Item item = (Item) loot;
          this.storeView.getTableModel().addRow(new Object[]{item.getName(), "" + item.getBuyPrice(), "" + item.getBonus(), item});
        }
      }
    }
    else if(storeType == StoreType.EQUIPMENT){
      for(Loot loot : AdventureSession.LOOTS){
        if(loot instanceof Equipment){
          Equipment equip = (Equipment) loot;
          this.storeView.getTableModel().addRow(new Object[]{equip.getName(), "" + equip.getBuyPrice(), "" + equip.getAttack(), equip.getDefense(), equip});
        }
      }
    }
    
    this.storeView.getBuyButton().addActionListener(new ActionListener() { 
      @Override
      public void actionPerformed(ActionEvent e) {
       int selectedRow = StoreEngine.this.storeView.getStoreTable().getSelectedRow();
       
       if(selectedRow > -1){
         Loot loot = (Loot) StoreEngine.this.storeView.getStoreTable().getValueAt(selectedRow, (columnLoot-1));
         
         if(AdventureSession.PLAYER.getGold() >= loot.getBuyPrice()){
           
           Boolean add = EngineSession.INVENTORY_ENGINE.addItem(loot);
           if(add){
             AdventureSession.PLAYER.setGold(AdventureSession.PLAYER.getGold() - loot.getBuyPrice());
             EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();             
           }else{
             JOptionPane.showMessageDialog(storeView, "Your inventory is full!");
           }
           
         }else{
           JOptionPane.showMessageDialog(storeView, "You don't have enough gold!");
         }
        
       }
       
      }
    });
    
    this.storeView.getExitButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        storeView.dispose();
      }
    });
    
  }
  
}
