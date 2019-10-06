package com.adventure.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.adventure.entity.Equipment;
import com.adventure.entity.Item;
import com.adventure.entity.Loot;
import com.adventure.entity.Monster;
import com.adventure.sessao.AdventureSession;
import com.adventure.type.LootType;

public class RandomLoot {

  public static Loot monsterDrop(Monster monster){
    if(dropped(monster.getLootChance())){
      if(monster.getLootType() == LootType.COPPER) return randomLoot(LootType.COPPER);
      if(monster.getLootType() == LootType.SILVER) return randomLoot(LootType.SILVER);
      if(monster.getLootType() == LootType.GOLD) return randomLoot(LootType.GOLD);
      if(monster.getLootType() == LootType.PLATINUM) return randomLoot(LootType.PLATINUM);
      if(monster.getLootType() == LootType.DIAMOND) return randomLoot(LootType.DIAMOND);
      if(monster.getLootType() == LootType.LEGENDARY) return randomLoot(LootType.LEGENDARY);
    }
    return null;
  }
  
  private static boolean dropped(Double dropChance){
    Random random = new Random();
    
    if(dropChance == 25d){
      if(random.nextInt(4) == 0){
        return true;
      }
    }
    
    if(dropChance == 50d){
      if(random.nextInt(2) == 0){
        return true;
      }
    }

    if(dropChance == 100d){
      return true;
    }
    return false;
  }
  
  public static Equipment randomEquipment(LootType type){
    List<Loot> loots = new ArrayList<Loot>();
    
    for(Loot loot : AdventureSession.LOOTS){
      if(loot.getLootType() == type && loot instanceof Equipment){
        loots.add(loot);
      }
    }
    
    if(!loots.isEmpty()){
      Random random = new Random();
      return (Equipment) loots.get(random.nextInt(loots.size()));      
    }
    
    return null;
  }
  
  public static Item randomItem(LootType type){
    List<Loot> loots = new ArrayList<Loot>();
    
    for(Loot loot : AdventureSession.LOOTS){
      if(loot.getLootType() == type && loot instanceof Item){
        loots.add(loot);
      }
    }
    
    if(!loots.isEmpty()){
      Random random = new Random();
      return (Item) loots.get(random.nextInt(loots.size()));      
    }
    
    return null;
  }
  
  private static Loot randomLoot(LootType type) {
	  
	  if(type == LootType.DIAMOND) {
		  Random random = new Random();
		  if(random.nextInt(10) == 0){
			  type = LootType.LEGENDARY;
		  }
	  }
	  
	  List<Loot> loots = new ArrayList<Loot>();
	    
	    for(Loot loot : AdventureSession.LOOTS){
	      if(loot.getLootType() == type){
	        loots.add(loot);
	      }
	    }
	    
	    if(!loots.isEmpty()){
	      Random random = new Random();
	      return loots.get(random.nextInt(loots.size()));      
	    }
	    return null;
  }

}
