package com.adventure.engine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.adventure.components.BoardSpace;
import com.adventure.entity.Item;
import com.adventure.entity.Loot;
import com.adventure.entity.Monster;
import com.adventure.entity.BattleMonster;
import com.adventure.sessao.AdventureSession;
import com.adventure.sessao.EngineSession;
import com.adventure.type.ItemType;
import com.adventure.utils.LevelUp;
import com.adventure.utils.RandomLoot;
import com.adventure.view.AdventureView;
import com.adventure.view.BattleView;

public class BattleEngine {

  private BattleView battleView;
  private BattleMonster monster;
  private Boolean isPlayerTurn;
  private InventoryEngine inventoryEngine;
  private Boolean endBattle;
  private BoardSpace boardSpace;
  
  public BattleEngine(Monster monster, AdventureView locationRelativeTo, BoardSpace boardSpace) {
    EngineSession.BATTLE_ENGINE(this);
    this.battleView = new BattleView();
    this.battleView.setLocationRelativeTo(locationRelativeTo);
    this.monster = preparaMonstroParaBatalha(monster);
    this.boardSpace = boardSpace;
    this.endBattle = false;
    
    prepareBattle();
    addEventsButton();
    drawTurn();
    loadInventoryEngine();
    this.battleView.setVisible(true);
    
    try {
      startBattle();
    } catch (InterruptedException e) {
      JOptionPane.showMessageDialog(battleView, "The battle cannot be started.");
      battleView.dispose();
    }
    
  }
  
  public BattleView getBattleView() {
    return battleView;
  }
  
  public InventoryEngine getInventoryEngine() {
    return inventoryEngine;
  }
  
  private void loadInventoryEngine(){
    this.inventoryEngine = new InventoryEngine(this.battleView.getInventoryPanel());
  }
  
  private void startBattle() throws InterruptedException{
    prepareActionsTurn();
    
    if(!isPlayerTurn){
      monsterTurn();
    }
    
  }
  
  private void monsterTurn() throws InterruptedException{
    prepareActionsTurn();
    beAttacked();
    if(!endBattle){
      isPlayerTurn = true;
      prepareActionsTurn();
    }
  }
  
  private void attack() throws InterruptedException{
    Integer attack = new Random().nextInt(AdventureSession.PLAYER.getAttack());
    Integer defense = this.monster.getDefense() / 2;
    Integer damage = attack - (attack * (defense/100));
    
    Integer currentlyLife = this.monster.getCurrentlyLife() - damage;
    
    if(currentlyLife <= 0){
      this.monster.setCurrentlyLife(0);
      loadAttributes();
      victory();
    }else{
      this.monster.setCurrentlyLife(currentlyLife);
      loadAttributes();
      isPlayerTurn = false;
      prepareActionsTurn();
      populateTable(AdventureSession.PLAYER.getName(), damage + " damage caused.", this.monster.getName());
      this.battleView.revalidate();
      this.battleView.repaint();
      monsterTurn();
    }
    
  }
  
  private void beAttacked(){
    Integer attack = new Random().nextInt(this.monster.getAttack());
    Integer defense = AdventureSession.PLAYER.getDefense();
    Integer damage = attack - (attack * (defense/100));
    
    Integer currentlyLife = AdventureSession.PLAYER.getCurrentlyLife() - damage;
    
    if(currentlyLife <= 0){
      AdventureSession.PLAYER.setCurrentlyLife(1);
      loadAttributes();
      defeat();
    }else{
      AdventureSession.PLAYER.setCurrentlyLife(currentlyLife);
      loadAttributes();
      isPlayerTurn = true;
      prepareActionsTurn();
      populateTable(this.monster.getName(), damage + " damage caused.", AdventureSession.PLAYER.getName());
      this.battleView.revalidate();
      this.battleView.repaint();
    }
    
  }
  
  private void populateTable(String attack, String description, String defense){
    ((DefaultTableModel)this.battleView.getBattleTable().getModel()).addRow(new String[]{attack, description, defense});
  }
  
  private void victory(){
    this.battleView.getAttackButton().setEnabled(false);
    this.battleView.getEscapeButton().setEnabled(false);
    this.battleView.getExitButton().setEnabled(true);
    
    JOptionPane.showMessageDialog(battleView, "CONGRATULATIONS, YOU WON!");
    
    if(LevelUp.isUpLevel((AdventureSession.PLAYER.getExp() + this.monster.getExp()), AdventureSession.PLAYER.getLevel())){
      JOptionPane.showMessageDialog(battleView, "CONGRATULATIONS, YOUR LEVEL IS INCREASED TO:  " + (AdventureSession.PLAYER.getLevel() + 1));
      AdventureSession.PLAYER.setExp(LevelUp.expReturn((AdventureSession.PLAYER.getExp() + this.monster.getExp()), AdventureSession.PLAYER.getLevel()));
      AdventureSession.PLAYER.setLevel(AdventureSession.PLAYER.getLevel() + 1);
      AdventureSession.PLAYER.setAttack(AdventureSession.PLAYER.getAttack() + 1);
      AdventureSession.PLAYER.setDefense(AdventureSession.PLAYER.getDefense() + 1);
      AdventureSession.PLAYER.setMaxLife(AdventureSession.PLAYER.getMaxLife() + 20);
      AdventureSession.PLAYER.setCurrentlyLife(AdventureSession.PLAYER.getMaxLife());
    }else{
      AdventureSession.PLAYER.setExp(AdventureSession.PLAYER.getExp() + this.monster.getExp());
    }
    
    AdventureSession.PLAYER.setGold(AdventureSession.PLAYER.getGold() + this.monster.getGold());
    
    Loot loot = RandomLoot.monsterDrop(this.monster);
    EngineSession.BOARD_ENGINE.foundLoot(battleView, loot);
    
    loadAttributes();
    EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
    
    EngineSession.BOARD_ENGINE.removeFill(boardSpace);
    
  }
  
  private void defeat(){
    this.battleView.getAttackButton().setEnabled(false);
    this.battleView.getEscapeButton().setEnabled(false);
    this.battleView.getExitButton().setEnabled(true);
    this.endBattle = true;
    loadAttributes();
    EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
    JOptionPane.showMessageDialog(battleView, "WHAT A SHAME, YOU'VE LOST!");
  }
  
  private void prepareBattle(){
    ((DefaultTableModel)this.battleView.getBattleTable().getModel()).setRowCount(0);
    loadAttributes();    
  }
  
  public void loadAttributes(){
    this.battleView.getAttributePanel().getValueAttack().setText("" + AdventureSession.PLAYER.getAttack());
    this.battleView.getAttributePanel().getValueDefense().setText("" + AdventureSession.PLAYER.getDefense());
    this.battleView.getAttributePanel().getValueExp().setText("" + AdventureSession.PLAYER.getExp() + " / " + LevelUp.expToNextLevel(AdventureSession.PLAYER.getLevel()));
    this.battleView.getAttributePanel().getValueLevel().setText("" + AdventureSession.PLAYER.getLevel());
    this.battleView.getAttributePanel().getValueName().setText("" + AdventureSession.PLAYER.getName());
    this.battleView.getAttributePanel().getValueGold().setText("" + AdventureSession.PLAYER.getGold());
    this.battleView.getAttributePanel().getValueLife().setText("" + AdventureSession.PLAYER.getCurrentlyLife() + " / " + AdventureSession.PLAYER.getMaxLife());
    
    this.battleView.getMonsterAttackValue().setText("" + this.monster.getAttack());
    this.battleView.getMonsterDefenseValue().setText("" + this.monster.getDefense());
    this.battleView.getMonsterExpValue().setText("" + this.monster.getExp());
    this.battleView.getMonsterGoldValue().setText("" + this.monster.getGold());
    this.battleView.getMonsterLifeValue().setText("" + this.monster.getCurrentlyLife() + " / " + this.monster.getMaxLife());
  }
  
  private void drawTurn(){
    Random random = new Random();
    if(random.nextInt(2) == 0){
     isPlayerTurn = true; 
    }else{
      isPlayerTurn = false;
    }
  }
  
  private void prepareActionsTurn(){
    if(isPlayerTurn){
      this.battleView.getTurnIndicatorLabel().setBackground(Color.green);
      this.battleView.getAttackButton().setEnabled(true);
      this.battleView.getEscapeButton().setEnabled(true);
    }else{
      this.battleView.getTurnIndicatorLabel().setBackground(Color.red);
      this.battleView.getAttackButton().setEnabled(false);
      this.battleView.getEscapeButton().setEnabled(false);
    }
    this.battleView.getExitButton().setEnabled(false);
  }
  
  private void addEventsButton(){
    this.battleView.getAttackButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          attack();
        } catch (InterruptedException e1) {
          JOptionPane.showMessageDialog(battleView, "Your attack missed, try again.");
        }
      }
    });
    
    this.battleView.getEscapeButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Item itemFuga = null;
        Boolean isPodeFugir = false;
        
        for(Loot loot : AdventureSession.PLAYER.getInventory().getLoots()){
          if(loot instanceof Item){
            if(((Item) loot).getType() == ItemType.ESCAPE){
              itemFuga = (Item) loot;
              isPodeFugir = true;
              break;
            }
          }
        }
        
        if(isPodeFugir){
          EngineSession.INVENTORY_ENGINE.useEscape(null, itemFuga);
        }else{
          JOptionPane.showMessageDialog(battleView, "You have no escape items!");
        }
      }
    });
    
    this.battleView.getExitButton().addActionListener(new ActionListener() { 
      @Override
      public void actionPerformed(ActionEvent e) {
        EngineSession.BATTLE_ENGINE(null);
        battleView.dispose();
      }
    });
    
  }
  
  private BattleMonster preparaMonstroParaBatalha(Monster monster){
    BattleMonster battleMonster = new BattleMonster();
    battleMonster.setAttack(monster.getAttack());
    battleMonster.setLootChance(monster.getLootChance());
    battleMonster.setDefense(monster.getDefense());
    battleMonster.setExp(monster.getExp());
    battleMonster.setGold(monster.getGold());
    battleMonster.setLoot(monster.getLoot());
    battleMonster.setLootType(monster.getLootType());
    battleMonster.setName(monster.getName());
    battleMonster.setType(monster.getType());
    battleMonster.setCurrentlyLife(monster.getCurrentlyLife());
    battleMonster.setMaxLife(monster.getMaxLife());
    return battleMonster;
  }
  
}
