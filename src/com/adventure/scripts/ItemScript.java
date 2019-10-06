package com.adventure.scripts;

import com.adventure.entity.Item;
import com.adventure.sessao.AdventureSession;
import com.adventure.type.ItemType;
import com.adventure.type.LootType;

public class ItemScript implements AdventureScript{

  @Override
  public void populateGameObjects() {
    
    Item pp = new Item();
    pp.setName("Small Life Potion");
    pp.setBonus(50);
    pp.setBuyPrice(20);
    pp.setSellPrice(5);
    pp.setType(ItemType.LIFE_POTION);
    pp.setLootType(LootType.COPPER);
    AdventureSession.addLoot(pp);
    
    Item pm = new Item();
    pm.setName("Medium Life Potion");
    pm.setBonus(100);
    pm.setBuyPrice(50);
    pm.setSellPrice(10);
    pm.setType(ItemType.LIFE_POTION);
    pm.setLootType(LootType.SILVER);
    AdventureSession.addLoot(pm);
    
    Item pg = new Item();
    pg.setName("Big Life Potion");
    pg.setBonus(200);
    pg.setBuyPrice(100);
    pg.setSellPrice(20);
    pg.setType(ItemType.LIFE_POTION);
    pg.setLootType(LootType.GOLD);
    AdventureSession.addLoot(pg);
    
    Item e = new Item();
    e.setName("Bag Expander");
    e.setBonus(1);
    e.setBuyPrice(5000);
    e.setSellPrice(100);
    e.setType(ItemType.BAG_EXPANDER);
    e.setLootType(LootType.GOLD);
    AdventureSession.addLoot(e);
    
    Item f = new Item();
    f.setName("Battle Escape");
    f.setBonus(0);
    f.setBuyPrice(100);
    f.setSellPrice(20);
    f.setType(ItemType.ESCAPE);
    f.setLootType(LootType.SILVER);
    AdventureSession.addLoot(f);
  }

}
