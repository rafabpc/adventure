package com.adventure.type;

public enum EquipmentType {

  HELMET("BE1"),
  BREASTPLATE("BE2"),
  PAINTS("BE3"),
  BOOTS("BE4"),
  WEAPON("BE5"),
  SHIELD("BE6");
  
  private String id;
  
  private EquipmentType(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
  
  public EquipmentType getTypeById(String id){
    if(id.equals(HELMET.getId())){
      return HELMET;
    }
    if(id.equals(BREASTPLATE.getId())){
      return BREASTPLATE;
    }
    if(id.equals(PAINTS.getId())){
      return PAINTS;
    }
    if(id.equals(BOOTS.getId())){
      return BOOTS;
    }
    if(id.equals(WEAPON.getId())){
      return WEAPON;
    }
    if(id.equals(SHIELD.getId())){
      return SHIELD;
    }
    return null;
  }
  
}
