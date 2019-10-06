package com.adventure.engine;

import com.adventure.sessao.AdventureSession;
import com.adventure.utils.LevelUp;
import com.adventure.view.AttributePanel;

public class AttributeEngine {

  private AttributePanel attributePanel;
  
  public AttributeEngine(AttributePanel attributePanel) {
    this.attributePanel = attributePanel;
    populateAttributes();
  }
  
  private void populateAttributes(){
    this.attributePanel.getValueAttack().setText("" + AdventureSession.PLAYER.getAttack());
    this.attributePanel.getValueDefense().setText("" + AdventureSession.PLAYER.getDefense());
    this.attributePanel.getValueExp().setText("" + AdventureSession.PLAYER.getExp() + " / " + LevelUp.expToNextLevel(AdventureSession.PLAYER.getLevel()));
    this.attributePanel.getValueLevel().setText("" + AdventureSession.PLAYER.getLevel());
    this.attributePanel.getValueName().setText("" + AdventureSession.PLAYER.getName());
    this.attributePanel.getValueGold().setText("" + AdventureSession.PLAYER.getGold());
    this.attributePanel.getValueLife().setText("" + AdventureSession.PLAYER.getCurrentlyLife() + " / " + AdventureSession.PLAYER.getMaxLife());
  }
  
  public void repopulaAtributos(){
    populateAttributes();
    attributePanel.revalidate();
    attributePanel.repaint();
  }
  
}
