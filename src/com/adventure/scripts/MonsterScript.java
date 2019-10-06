package com.adventure.scripts;

import com.adventure.entity.Loot;
import com.adventure.entity.Monster;
import com.adventure.sessao.AdventureSession;
import com.adventure.type.LootType;
import com.adventure.type.MonsterType;

public class MonsterScript implements AdventureScript{

  @Override
  public void populateGameObjects() {
    Monster rat = new Monster();
    rat.setName(MonsterType.RAT.getDescription());
    rat.setAttack(2);
    rat.setDefense(2);
    rat.setExp(10);
    rat.setGold(10);
    rat.setLoot(createRandomLoot());
    rat.setType(MonsterType.RAT);
    rat.setCurrentlyLife(20);
    rat.setMaxLife(20);
    rat.setLootChance(25d);
    rat.setLootType(LootType.COPPER);
    AdventureSession.addMonsters(rat);
    
    Monster wolf = new Monster();
    wolf.setName(MonsterType.WOLF.getDescription());
    wolf.setAttack(4);
    wolf.setDefense(3);
    wolf.setExp(25);
    wolf.setGold(30);
    wolf.setLoot(createRandomLoot());
    wolf.setType(MonsterType.WOLF);
    wolf.setCurrentlyLife(45);
    wolf.setMaxLife(45);
    wolf.setLootChance(50d);
    wolf.setLootType(LootType.COPPER);
    AdventureSession.addMonsters(wolf);
    
    Monster spider = new Monster();
    spider.setName(MonsterType.SPIDER.getDescription());
    spider.setAttack(5);
    spider.setDefense(3);
    spider.setExp(30);
    spider.setGold(30);
    spider.setLoot(createRandomLoot());
    spider.setType(MonsterType.SPIDER);
    spider.setCurrentlyLife(45);
    spider.setMaxLife(45);
    spider.setLootChance(25d);
    spider.setLootType(LootType.SILVER);
    AdventureSession.addMonsters(spider);
    
    Monster crocodile = new Monster();
    crocodile.setName(MonsterType.CROCODILE.getDescription());
    crocodile.setAttack(3);
    crocodile.setDefense(10);
    crocodile.setExp(60);
    crocodile.setGold(50);
    crocodile.setLoot(createRandomLoot());
    crocodile.setType(MonsterType.CROCODILE);
    crocodile.setCurrentlyLife(80);
    crocodile.setMaxLife(80);
    crocodile.setLootChance(50d);
    crocodile.setLootType(LootType.SILVER);
    AdventureSession.addMonsters(crocodile);
    
    Monster bear = new Monster();
    bear.setName(MonsterType.BEAR.getDescription());
    bear.setAttack(10);
    bear.setDefense(7);
    bear.setExp(100);
    bear.setGold(100);
    bear.setLoot(createRandomLoot());
    bear.setType(MonsterType.BEAR);
    bear.setCurrentlyLife(80);
    bear.setMaxLife(80);
    bear.setLootChance(100d);
    bear.setLootType(LootType.SILVER);
    AdventureSession.addMonsters(bear);
    
    Monster dragon = new Monster();
    dragon.setName(MonsterType.DRAGON.getDescription());
    dragon.setAttack(15);
    dragon.setDefense(10);
    dragon.setExp(250);
    dragon.setGold(200);
    dragon.setLoot(createRandomLoot());
    dragon.setType(MonsterType.DRAGON);
    dragon.setCurrentlyLife(400);
    dragon.setMaxLife(400);
    dragon.setLootChance(25d);
    dragon.setLootType(LootType.GOLD);
    AdventureSession.addMonsters(dragon);
    
    Monster demon = new Monster();
    demon.setName(MonsterType.DEMON.getDescription());
    demon.setAttack(25);
    demon.setDefense(20);
    demon.setExp(500);
    demon.setGold(1000);
    demon.setLoot(createRandomLoot());
    demon.setType(MonsterType.DEMON);
    demon.setCurrentlyLife(700);
    demon.setMaxLife(700);
    demon.setLootChance(25d);
    demon.setLootType(LootType.PLATINUM);
    AdventureSession.addMonsters(demon);
    
    Monster demonLord = new Monster();
    demonLord.setName(MonsterType.DEMON_LORD.getDescription());
    demonLord.setAttack(100);
    demonLord.setDefense(100);
    demonLord.setExp(2000);
    demonLord.setGold(10000);
    demonLord.setLoot(createRandomLoot());
    demonLord.setType(MonsterType.DEMON_LORD);
    demonLord.setCurrentlyLife(2000);
    demonLord.setMaxLife(2000);
    demonLord.setLootChance(25d);
    demonLord.setLootType(LootType.DIAMOND);
    AdventureSession.addMonsters(demonLord);
    
  }
  
  public Loot createRandomLoot(){
    return null;
  }

}
