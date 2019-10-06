package com.adventure.type;

public enum FillType {

  PLAYER              ("P1", "Player"),
  GOLD_CHEST                ("BO", "Gold Chest"),
  COPPER_ITEM_CHEST         ("BIB", "Item Chest"),
  SILVER_ITEM_CHEST          ("BIP", "Item Chest"),
  GOLD_ITEM_CHEST           ("BIO", "Item Chest"),
  COPPER_EQUIPMENT_CHEST  ("BEB", "Equipment Chest"),
  SILVER_EQUIPMENT_CHEST   ("BEP", "Equipment Chest"),
  GOLD_EQUIPMENT_CHEST    ("BEO", "Equipment Chest"),
  PLATINUM_EQUIPMENT_CHEST    ("BEX", "Equipment Chest"),
  DIAMOND_EQUIPMENT_CHEST    ("BED", "Equipment Chest"),
  LEGENDARY_EQUIPMENT_CHEST    ("BEL", "Equipment Chest"),
  EXIT                   ("S", "Exit"),
  MONSTER                 ("M", "Monster"),
  EQUIPMENTS_STORE       ("LE", "Equipments Store"),
  ITENS_STORE              ("LI", "Itens Store"),
  PLAY                   ("JO", "Play"),
  LOGOUT                    ("SA", "Logout"),
  SAVE                  ("SV", "Save"),
  LOAD                ("CA", "Load"),
  NEW_GAME               ("NV", "New Game"),
  MENU                  ("INI", "Menu"),
  CREDITS                ("CR", "Credits");
  
  private String id;
  private String description;
  
  private FillType(String id, String description) {
    this.id = id;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }
  
  public static FillType getTypeById(String id){
    if(id.equals(PLAYER.getId())){
      return PLAYER;
    }
    else if(id.contains(GOLD_CHEST.getId())){
      return GOLD_CHEST;
    }
    else if(id.contains(COPPER_ITEM_CHEST.getId())){
      return COPPER_ITEM_CHEST;
    }
    else if(id.contains(SILVER_ITEM_CHEST.getId())){
      return SILVER_ITEM_CHEST;
    }
    else if(id.contains(GOLD_ITEM_CHEST.getId())){
      return GOLD_ITEM_CHEST;
    }
    else if(id.contains(COPPER_EQUIPMENT_CHEST.getId())){
      return COPPER_EQUIPMENT_CHEST;
    }
    else if(id.contains(SILVER_EQUIPMENT_CHEST.getId())){
      return SILVER_EQUIPMENT_CHEST;
    }
    else if(id.contains(GOLD_EQUIPMENT_CHEST.getId())){
      return GOLD_EQUIPMENT_CHEST;
    }
    else if(id.contains(PLATINUM_EQUIPMENT_CHEST.getId())){
        return PLATINUM_EQUIPMENT_CHEST;
    }
    else if(id.contains(DIAMOND_EQUIPMENT_CHEST.getId())){
        return DIAMOND_EQUIPMENT_CHEST;
    }
    else if(id.contains(LEGENDARY_EQUIPMENT_CHEST.getId())){
        return LEGENDARY_EQUIPMENT_CHEST;
    }
    else if(id.equals(EXIT.getId())){
      return EXIT;
    }
    else if(id.contains(MONSTER.getId())){
      return MONSTER;
    }
    else if(id.equals(EQUIPMENTS_STORE.getId())){
      return EQUIPMENTS_STORE;
    }
    else if(id.equals(ITENS_STORE.getId())){
      return ITENS_STORE;
    }
    else if(id.equals(PLAY.getId())){
      return PLAY;
    }
    else if(id.equals(LOGOUT.getId())){
      return LOGOUT;
    }
    else if(id.equals(SAVE.getId())){
      return SAVE;
    }
    else if(id.equals(LOAD.getId())){
      return LOAD;
    }
    else if(id.equals(NEW_GAME.getId())){
      return NEW_GAME;
    }
    else if(id.equals(MENU.getId())){
      return MENU;
    }
    else if(id.equals(CREDITS.getId())){
      return CREDITS;
    }
    return null;
  }
  
  public static String getDescricaoById(String id){
    if(id.equals(PLAYER.getId())){
      return PLAYER.getDescription();
    }
    else if(id.contains(GOLD_CHEST.getId())){
      return GOLD_CHEST.getDescription();
    }
    else if(id.contains(COPPER_ITEM_CHEST.getId())){
      return COPPER_ITEM_CHEST.getDescription();
    }
    else if(id.contains(SILVER_ITEM_CHEST.getId())){
      return SILVER_ITEM_CHEST.getDescription();
    }
    else if(id.contains(GOLD_ITEM_CHEST.getId())){
      return GOLD_ITEM_CHEST.getDescription();
    }
    else if(id.contains(COPPER_EQUIPMENT_CHEST.getId())){
      return COPPER_EQUIPMENT_CHEST.getDescription();
    }
    else if(id.contains(SILVER_EQUIPMENT_CHEST.getId())){
      return SILVER_EQUIPMENT_CHEST.getDescription();
    }
    else if(id.contains(GOLD_EQUIPMENT_CHEST.getId())){
      return GOLD_EQUIPMENT_CHEST.getDescription();
    }
    else if(id.contains(PLATINUM_EQUIPMENT_CHEST.getId())){
        return PLATINUM_EQUIPMENT_CHEST.getDescription();
    }
    else if(id.contains(DIAMOND_EQUIPMENT_CHEST.getId())){
        return DIAMOND_EQUIPMENT_CHEST.getDescription();
    }
    else if(id.contains(LEGENDARY_EQUIPMENT_CHEST.getId())){
        return LEGENDARY_EQUIPMENT_CHEST.getDescription();
    }
    else if(id.equals(EXIT.getId())){
      return EXIT.getDescription();
    }
    else if(id.contains(MONSTER.getId())){
      return MONSTER.getDescription();
    }
    else if(id.equals(EQUIPMENTS_STORE.getId())){
      return EQUIPMENTS_STORE.getDescription();
    }
    else if(id.equals(ITENS_STORE.getId())){
      return ITENS_STORE.getDescription();
    }
    else if(id.equals(PLAY.getId())){
      return PLAY.getDescription();
    }
    else if(id.equals(LOGOUT.getId())){
      return LOGOUT.getDescription();
    }
    else if(id.equals(SAVE.getId())){
      return SAVE.getDescription();
    }
    else if(id.equals(LOAD.getId())){
      return LOAD.getDescription();
    }
    else if(id.equals(NEW_GAME.getId())){
      return NEW_GAME.getDescription();
    }
    else if(id.equals(MENU.getId())){
      return MENU.getDescription();
    }
    else if(id.equals(CREDITS.getId())){
      return CREDITS.getDescription();
    }
    return "";
  }
  
}