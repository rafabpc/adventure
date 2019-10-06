package com.adventure.engine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.adventure.entity.Equipment;
import com.adventure.scripts.PlayerScript;
import com.adventure.sessao.AdventureSession;
import com.adventure.sessao.EngineSession;
import com.adventure.type.EquipmentType;
import com.adventure.view.EquipmentPanel;

public class EquipmentEngine {

  private EquipmentPanel equipmentPanel;
  
  public EquipmentEngine(EquipmentPanel equipmentPanel) {
    this.equipmentPanel = equipmentPanel;
    loadEquipments();
    calculateAttributes();
  }
  
  private void loadEquipment(Equipment equip){
    if(equip.getType() == EquipmentType.HELMET && equipmentPanel.getHelmetEquip().getListeners(MouseListener.class).length == 0){
      equipmentPanel.getHelmetEquip().setToolTipText("<html> " + equip.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
      equipmentPanel.getHelmetEquip().setBackground(equip.getColor());
      removeEquipmentEvents(equipmentPanel.getHelmetEquip());
      addEquipmentEvent(equipmentPanel.getHelmetEquip(), equip);
    }
    else if(equip.getType() == EquipmentType.BREASTPLATE && equipmentPanel.getBreastplateEquip().getListeners(MouseListener.class).length == 0){
      equipmentPanel.getBreastplateEquip().setToolTipText("<html> " + equip.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
      equipmentPanel.getBreastplateEquip().setBackground(equip.getColor());
      removeEquipmentEvents(equipmentPanel.getBreastplateEquip());
      addEquipmentEvent(equipmentPanel.getBreastplateEquip(), equip);
    }
    else if(equip.getType() == EquipmentType.WEAPON && equipmentPanel.getWeaponEquip().getListeners(MouseListener.class).length == 0){
      equipmentPanel.getWeaponEquip().setToolTipText("<html> " + equip.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
      equipmentPanel.getWeaponEquip().setBackground(equip.getColor());
      removeEquipmentEvents(equipmentPanel.getWeaponEquip());
      addEquipmentEvent(equipmentPanel.getWeaponEquip(), equip);
    }
    else if(equip.getType() == EquipmentType.SHIELD && equipmentPanel.getShieldEquip().getListeners(MouseListener.class).length == 0){
      equipmentPanel.getShieldEquip().setToolTipText("<html> " + equip.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
      equipmentPanel.getShieldEquip().setBackground(equip.getColor());
      removeEquipmentEvents(equipmentPanel.getShieldEquip());
      addEquipmentEvent(equipmentPanel.getShieldEquip(), equip);
    }
    else if(equip.getType() == EquipmentType.PAINTS && equipmentPanel.getPaintsEquip().getListeners(MouseListener.class).length == 0){
      equipmentPanel.getPaintsEquip().setToolTipText("<html> " + equip.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
      equipmentPanel.getPaintsEquip().setBackground(equip.getColor());
      removeEquipmentEvents(equipmentPanel.getPaintsEquip());
      addEquipmentEvent(equipmentPanel.getPaintsEquip(), equip);
    }
    else if(equip.getType() == EquipmentType.BOOTS && equipmentPanel.getBootsEquip().getListeners(MouseListener.class).length == 0){
      equipmentPanel.getBootsEquip().setToolTipText("<html> " + equip.getName() + " <br/> Attack: " + equip.getAttack() + " <br/> Defense: "+ equip.getDefense() +"</html>");
      equipmentPanel.getBootsEquip().setBackground(equip.getColor());
      removeEquipmentEvents(equipmentPanel.getBootsEquip());
      addEquipmentEvent(equipmentPanel.getBootsEquip(), equip);
    }
  }
  
  private void loadEquipments(){
    for(Equipment equip : AdventureSession.PLAYER.getEquippedEquipments()){
      loadEquipment(equip);
    }
  }
  
  private void removeEquipmentEvents(JLabel label){
    MouseListener[] events = label.getListeners(MouseListener.class);
    for(MouseListener event : events){
      label.removeMouseListener(event);
    }
  }
  
  private void addEquipmentEvent(final JLabel label, final Equipment equip){
    if(label.getListeners(MouseAdapter.class).length == 0){
      label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          if(e.getButton() == MouseEvent.BUTTON3){
            if(equip != null && label.getToolTipText() != null){
              int op = JOptionPane.showConfirmDialog(equipmentPanel, "Do you really want to remove the equipment: " + equip.getName() + " ?");
              if(op == 0){
                removeEquipmentEvents(label);
                label.setBackground(new JLabel().getBackground());
                label.setToolTipText(null);
                unequip(equip);
                equipmentPanel.revalidate();
                equipmentPanel.repaint();
              }
            } 
          }
        }
      });      
    }
  }
  
  private void unequip(Equipment equip){
    for(int x=0; x<AdventureSession.PLAYER.getEquippedEquipments().size(); x++){
      if(AdventureSession.PLAYER.getEquippedEquipments().get(x).getName().equals(equip.getName())){
        AdventureSession.PLAYER.getEquippedEquipments().remove(x);
        break;
      }
    }
    AdventureSession.PLAYER.getInventory().getLoots().add(equip);
    AdventureSession.PLAYER.getInventory().setOccupiedSpace(AdventureSession.PLAYER.getInventory().getOccupiedSpace() + 1);
    AdventureSession.PLAYER.getInventory().setEmptySpace(AdventureSession.PLAYER.getInventory().getEmptySpace() - 1);
    AdventureSession.PLAYER.setAttack(AdventureSession.PLAYER.getAttack() - equip.getAttack());
    AdventureSession.PLAYER.setDefense(AdventureSession.PLAYER.getDefense() - equip.getDefense());
    
    EngineSession.INVENTORY_ENGINE.repopulateInventory();
    EngineSession.ATTRIBUTE_ENGINE.repopulaAtributos();
    
  }
  
  private void reloadAttributes(Equipment equip){
    AdventureSession.PLAYER.setAttack(AdventureSession.PLAYER.getAttack() + equip.getAttack());
    AdventureSession.PLAYER.setDefense(AdventureSession.PLAYER.getDefense() + equip.getDefense());
  }
  
  private void clearAttributes(){
    AdventureSession.PLAYER.setAttack(PlayerScript.getInitialAttack());
    AdventureSession.PLAYER.setDefense(PlayerScript.getInitialDefense());
  }
  
  private void calculateAttributes(){
    for(Equipment equip : AdventureSession.PLAYER.getEquippedEquipments()){
      reloadAttributes(equip);
    }
  }
  
  private void clearEquipments(){
    equipmentPanel.getHelmetEquip().setToolTipText("");
    equipmentPanel.getHelmetEquip().setBackground(new JLabel().getBackground());
    removeEquipmentEvents(equipmentPanel.getHelmetEquip());
    
    equipmentPanel.getBreastplateEquip().setToolTipText("");
    equipmentPanel.getBreastplateEquip().setBackground(new JLabel().getBackground());
    removeEquipmentEvents(equipmentPanel.getBreastplateEquip());
    
    equipmentPanel.getPaintsEquip().setToolTipText("");
    equipmentPanel.getPaintsEquip().setBackground(new JLabel().getBackground());
    removeEquipmentEvents(equipmentPanel.getPaintsEquip());
    
    equipmentPanel.getWeaponEquip().setToolTipText("");
    equipmentPanel.getWeaponEquip().setBackground(new JLabel().getBackground());
    removeEquipmentEvents(equipmentPanel.getWeaponEquip());
    
    equipmentPanel.getShieldEquip().setToolTipText("");
    equipmentPanel.getShieldEquip().setBackground(new JLabel().getBackground());
    removeEquipmentEvents(equipmentPanel.getShieldEquip());
    
    equipmentPanel.getBootsEquip().setToolTipText("");
    equipmentPanel.getBootsEquip().setBackground(new JLabel().getBackground());
    removeEquipmentEvents(equipmentPanel.getBootsEquip());
  }
  
  public void reloadEquipments(){
    clearAttributes();
    clearEquipments();
    loadEquipments();
    calculateAttributes();
    equipmentPanel.revalidate();
    equipmentPanel.repaint();
  }
}
