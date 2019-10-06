package com.adventure.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.adventure.components.BoardSpace;

public class BoardPanel extends JPanel{

  private static final long serialVersionUID = 1L;
  private BoardSpace matrix[][]; 
  
  public BoardPanel() {
      initialize();
  }
  
  private void initialize(){
    this.setLayout(new GridLayout(20, 20));
  }

  public BoardSpace[][] getMatrix() {
    if(matrix == null){
      matrix = new BoardSpace[20][20];  
    }
    return matrix;
  }

  public void setMatrix(BoardSpace[][] matrix) {
    this.matrix = matrix;
  }
  
}
