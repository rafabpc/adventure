package com.adventure.utils;

import java.util.Random;

public class RandomGold {

  private static final Integer[] RANDOM_LOW = new Integer[]{0,5};
  private static final Integer[] RANDOM_MEDIUM = new Integer[]{6,9};
  private static final Integer[] RANDOM_HIGH = new Integer[]{10, 11};
  
  private static final Integer[] LOW_VALUE = new Integer[]{1, 100};
  private static final Integer[] MEDIUM_VALUE = new Integer[]{101, 500};
  private static final Integer[] HIGH_VALUE = new Integer[]{501, 1000};
  
  public static Integer randomGold(){
    Random random = new Random();
    Integer randomNumber = random.nextInt(10);
    
    if(randomNumber >= RANDOM_LOW[0] && randomNumber<=RANDOM_LOW[1]){
      return new Random().nextInt((LOW_VALUE[1] - LOW_VALUE[0]) + 1) + LOW_VALUE[0];
    }
    
    else if(randomNumber >= RANDOM_MEDIUM[0] && randomNumber<=RANDOM_MEDIUM[1]){
      return new Random().nextInt((MEDIUM_VALUE[1] - MEDIUM_VALUE[0]) + 1) + MEDIUM_VALUE[0];
    }

    else if(randomNumber >= RANDOM_HIGH[0] && randomNumber<=RANDOM_HIGH[1]){
      return new Random().nextInt((HIGH_VALUE[1] - HIGH_VALUE[0]) + 1) + HIGH_VALUE[0];
    }
    
    return 0;
    
  }
  
}
