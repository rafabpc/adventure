package com.adventure.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdventureView extends JFrame{

  private static final long serialVersionUID = 1L;
  
  private JPanel mainPanel;
  private BoardPanel boardPanel;
  private ProfilePanel profilePanel;
  
  public AdventureView() {
    initialize();
  }
  
  private void initialize(){
    this.setTitle("ADVENTURE GAME");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(new Dimension(1260, 860));
    this.setLocationRelativeTo(null);
    this.setContentPane(getMainPanel());
  }
  
  public JPanel getMainPanel() {
    if(mainPanel == null){
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(getBoardPanel(), BorderLayout.CENTER);
      mainPanel.add(getProfilePanel(), BorderLayout.EAST);
    }
    return mainPanel;
  }
  
  public BoardPanel getBoardPanel() {
    if(boardPanel == null){
      boardPanel = new BoardPanel();
    }
    return boardPanel;
  }

  public ProfilePanel getProfilePanel() {
    if(profilePanel == null){
      profilePanel = new ProfilePanel();
    }
    return profilePanel;
  }
  
}
