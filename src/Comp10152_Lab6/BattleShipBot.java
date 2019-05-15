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
 * @author Jinkal Dudhat, 000762953
 * @author akash patel, 000761062
 */
public class BattleShipBot {
    private int gameSize;
    private BattleShip battleShip;
    private Random random;
    ShotsRecord shotsrecord;
    
    /**
     * constructor for battleship
     * @param b is an instance of battleship
     */
    public BattleShipBot(BattleShip b) {
        battleShip = b;
        gameSize = b.BOARDSIZE;
        shotsrecord = new ShotsRecord();
        random = new Random();   // Needed for random shooter - not required for more systematic approaches
    }
    
    /**
     * this method performs shot and print status of fires shot "Hit" or "Miss"
     * @return hit if its true
     */
    public boolean fireShot() {
        boolean shotFired = false;
        int x = 0, y = 0;
        Point finalShot = new Point(0, 0);
        while (!shotFired) {
            x = random.nextInt(gameSize);
            y = random.nextInt(gameSize);
            if ((y + x) % 2 == 1) {
                String shotstatus = shotsrecord.returnCellState(x, y);
                if (shotstatus == "Empty") {
                    finalShot = new Point(x, y);
                  //shotFired = true;
                    break;
                }
            }
        }
        boolean hit = battleShip.shoot(finalShot);
        String status = "";
        if (hit == true) {
            status = "Hit";
            shotsrecord.insert(x, y, status);
            shotrecfire(x + 1, y);
            shotrecfire(x - 1, y);
            shotrecfire(x, y + 1);
            shotrecfire(x, y - 1);
        } else {
            status = "Miss";
            shotsrecord.insert(x, y, status);
        }

        return hit;
    }

    /**
     * this method takes x and y coordinate and hit the shot on that point
     * @param x is used for x coordinate
     * @param y is used for y coordinate
     */
    public void shotrecfire(int x, int y) {
        if (battleShip.allSunk()) {
            return;
        }
        if (x < 0 || x > 9 || y < 0 || y > 9) {
          
        } else {
            Point finalShot = new Point(x, y);
            if (battleShip.shoot(finalShot)) {
                String status = "Hit";
                shotsrecord.insert(x, y, status);
//                if (!battleShip.allSunk()) {
//                    shotrecfire(x + 1, y);
//                }
//                if (!battleShip.allSunk()) {
//                    shotrecfire(x - 1, y);
//                }
//                if (!battleShip.allSunk()) {
//                    shotrecfire(x, y + 1);
//                }
//                if (!battleShip.allSunk()) {
//                    shotrecfire(x, y - 1);
//                }
            } else {
                String status = "Miss";
                shotsrecord.insert(x, y, status);
            }
        }
    }

}
