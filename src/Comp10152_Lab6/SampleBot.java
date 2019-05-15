/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comp10152_Lab6;

import battleship.BattleShip;
import java.awt.Point;
import java.util.Random;

/**
 * A Sample random shooter - Takes no precaution on double shooting and has no strategy once 
 * a ship is hit.
 * 
 * @author Jinkal Dudhat, 000762953
 * @author akash patel, 000761062
 */
public class SampleBot
{
  private int gameSize;
  private BattleShip battleShip;
  private Random random;

  /**
   * Constructor keeps a copy of the BattleShip instance
   * @param b previously created battleship instance - should be a new game
   */
  public SampleBot(BattleShip b)
  {
    battleShip = b;
    gameSize = b.BOARDSIZE;
    random = new Random();   // Needed for random shooter - not required for more systematic approaches
  }

  /**
   * Create a random shot and calls the battleship shoot method
   * @return true if a Ship is hit, false otherwise
   */
  
  public boolean fireShot()
  {
    int x = random.nextInt(gameSize);
    int y = random.nextInt(gameSize);
    Point shot = new Point(x,y);
    boolean hit = battleShip.shoot(shot);
    
    return hit;
  }
}
