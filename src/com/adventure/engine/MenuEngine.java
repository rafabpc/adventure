package com.adventure.engine;

import com.adventure.view.AdventureView;

public class MenuEngine {

  private AdventureView gameScreen;
  
  public MenuEngine(AdventureView telaJogo) {
    this.gameScreen = telaJogo;
    preparateScreen();
  }
  
  private void preparateScreen(){
    this.gameScreen.getProfilePanel().setVisible(false);
  }
  
}
