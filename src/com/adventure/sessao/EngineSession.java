package com.adventure.sessao;

import java.io.File;

import com.adventure.engine.AttributeEngine;
import com.adventure.engine.BattleEngine;
import com.adventure.engine.ScriptEngine;
import com.adventure.engine.EquipmentEngine;
import com.adventure.engine.InventoryEngine;
import com.adventure.engine.MenuEngine;
import com.adventure.engine.BoardEngine;
import com.adventure.view.AdventureView;

public class EngineSession {

  public static ScriptEngine SCRIPT_ENGINE;
  public static BoardEngine BOARD_ENGINE;
  public static EquipmentEngine EQUIPMENT_ENGINE;
  public static AttributeEngine ATTRIBUTE_ENGINE;
  public static InventoryEngine INVENTORY_ENGINE;
  public static MenuEngine MENU_ENGINE;
  private static BattleEngine BATTLE_ENGINE = null;
  
  
  static{
    SCRIPT_ENGINE = new ScriptEngine();
    AdventureView frame = new AdventureView();
    BOARD_ENGINE = new BoardEngine(frame, new File(System.getProperty("user.dir") + "/maps/Menu.map"));
    EQUIPMENT_ENGINE =  new EquipmentEngine(frame.getProfilePanel().getEquipmentPanel());
    ATTRIBUTE_ENGINE =  new AttributeEngine(frame.getProfilePanel().getAttributePanel());
    INVENTORY_ENGINE = new InventoryEngine(frame.getProfilePanel().getInventoryPanel());
    MENU_ENGINE = new MenuEngine(frame);
    frame.setVisible(true);
  }
  
  public static BattleEngine getBatalhaEngine(){
    return BATTLE_ENGINE;
  }
  
  public static void BATTLE_ENGINE(BattleEngine batalhaEngine) {
    BATTLE_ENGINE = batalhaEngine;
  }
}
