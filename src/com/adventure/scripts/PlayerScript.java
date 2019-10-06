package com.adventure.scripts;

import java.util.ArrayList;
import java.util.List;

import com.adventure.entity.Equipment;
import com.adventure.entity.Inventory;
import com.adventure.entity.Player;
import com.adventure.entity.Loot;
import com.adventure.sessao.AdventureSession;

public class PlayerScript implements AdventureScript{

  @Override
  public void populateGameObjects() {
    Player player = new Player();
    player.setName("Player");
    player.setLevel(1);
    player.setExp(0);
    player.setMaxLife(100);
    player.setCurrentlyLife(100);
    player.setAttack(5);
    player.setDefense(5);
    player.setEquippedEquipments(createEquippedEquipments());
    player.setInventory(createInventory());
    player.setGold(0);
    AdventureSession.setPlayer(player);
  }

  public static void reStart(){
    Player player = new Player();
    player.setName("Player");
    player.setLevel(1);
    player.setExp(0);
    player.setMaxLife(100);
    player.setCurrentlyLife(100);
    player.setAttack(5);
    player.setDefense(5);
    player.setEquippedEquipments(createEquippedEquipments());
    player.setInventory(createInventory());
    player.setGold(0);
    AdventureSession.PLAYER = player;
  }
  
  private static List<Equipment> createEquippedEquipments(){
    List<Equipment> equipados = new ArrayList<Equipment>();
    equipados.add((Equipment) createEquipment());
    return equipados;
  }
  
  private static Inventory createInventory(){
    Inventory inventario = new Inventory();
    inventario.setLoots(new ArrayList<Loot>());
    inventario.getLoots().add(createLoot());
    inventario.setTotalSpace(12);
    inventario.setEmptySpace(11);
    inventario.setOccupiedSpace(1);
    return inventario;
  }
  
  private static Loot createLoot(){
    return AdventureSession.LOOTS.get(36);
  }
  
  private static Loot createEquipment(){
    return AdventureSession.LOOTS.get(24);
  }
  
  public static Integer getInitialAttack(){
    return 5;
  }
  
  public static Integer getInitialDefense(){
    return 5;
  }
}
