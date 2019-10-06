package com.adventure.utils;

public class LevelUp {

  public static Integer expToNextLevel(Integer level){
    return level * 100;
  }
  
  public static boolean isUpLevel(Integer exp, Integer level){
    if(exp >= (level * 100)){
      return true;
    }else{
      return false;
    }
  }
  
  public static Integer expReturn(Integer exp, Integer level){
    return exp - (level * 100);
  }
  
}
