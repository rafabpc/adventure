package com.adventure.engine;

import java.util.ArrayList;
import java.util.List;

import com.adventure.scripts.AdventureScript;
import com.adventure.scripts.EquipmentScript;
import com.adventure.scripts.ItemScript;
import com.adventure.scripts.PlayerScript;
import com.adventure.scripts.MonsterScript;

public class ScriptEngine {

  private List<AdventureScript> scripts;
  
  public ScriptEngine() {
    populateScriptList();
    executeScripts();
  }
  
  private void populateScriptList(){
    scripts = new ArrayList<AdventureScript>();
    scripts.add(new EquipmentScript());
    scripts.add(new ItemScript());
    scripts.add(new PlayerScript());
    scripts.add(new MonsterScript());
  }
  
  private void executeScripts(){
    for(AdventureScript carga : scripts){
      carga.populateGameObjects();
    }
  }
  
}
