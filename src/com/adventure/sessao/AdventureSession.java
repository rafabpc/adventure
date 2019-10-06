package com.adventure.sessao;

import java.util.ArrayList;
import java.util.List;

import com.adventure.entity.Player;
import com.adventure.entity.Loot;
import com.adventure.entity.Monster;
import com.adventure.type.MonsterType;

public abstract class AdventureSession {

  public static Player PLAYER;
  public static List<Monster> MONSTERS;
  public static List<Loot> LOOTS;
  
  public static void setPlayer(Player player){
    if(PLAYER == null){
      PLAYER = player;      
    }
  }
  
  public static void addMonsters(Monster monster){
    if(MONSTERS == null){
      MONSTERS = new ArrayList<Monster>();
    }
    MONSTERS.add(monster);
  }
  
  public static Monster getMonster(MonsterType type){
    for(Monster monster : MONSTERS){
      if(monster.getType() == type){
        return monster;
      }
    }
    return null;
  }
  
  public static void addLoot(Loot loot){
    if(LOOTS == null){
      LOOTS = new ArrayList<Loot>();
    }
    LOOTS.add(loot);
  }
}
