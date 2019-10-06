package com.adventure.type;

public enum MonsterType {

  RAT      	("M1", "Rat"),
  WOLF      ("M2", "Wolf"),
  SPIDER    ("M3", "Spider"),
  CROCODILE ("M4", "Crocodile"),
  BEAR      ("M5", "Bear"),
  DRAGON    ("M6", "Dragon"),
  DEMON		("M7", "Demon"),
  DEMON_LORD("M8", "Demon Lord");
  
  private String id;
  private String description;
  
  private MonsterType(String id, String description) {
    this.id = id;
    this.description = description;
  }
  
  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }
  
  public static String getDescricaoById(String id){
    if(id.equals(RAT.getId())){
      return RAT.getDescription();
    }
    if(id.equals(WOLF.getId())){
      return WOLF.getDescription();
    }
    if(id.equals(SPIDER.getId())){
      return SPIDER.getDescription();
    }
    if(id.equals(CROCODILE.getId())){
      return CROCODILE.getDescription();
    }
    if(id.equals(BEAR.getId())){
      return BEAR.getDescription();
    }
    if(id.equals(DRAGON.getId())){
      return DRAGON.getDescription();
    }
    if(id.equals(DEMON.getId())){
        return DEMON.getDescription();
    }
    if(id.equals(DEMON_LORD.getId())){
        return DEMON_LORD.getDescription();
      }
    return "";
  }
  
  public static MonsterType getTypeById(String id){
    if(id.equals(RAT.getId())){
      return RAT;
    }
    if(id.equals(WOLF.getId())){
      return WOLF;
    }
    if(id.equals(SPIDER.getId())){
      return SPIDER;
    }
    if(id.equals(CROCODILE.getId())){
      return CROCODILE;
    }
    if(id.equals(BEAR.getId())){
      return BEAR;
    }
    if(id.equals(DRAGON.getId())){
      return DRAGON;
    }
    if(id.equals(DEMON.getId())){
        return DEMON;
    }
    if(id.equals(DEMON_LORD.getId())){
        return DEMON_LORD;
      }
    return null;
  }
  
}
