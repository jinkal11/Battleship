/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comp10152_Lab6;

import battleship.BattleShip;

/**
 * @author Jinkal Dudhat, 000762953
 * @author akash patel, 000761062
 */
public class Comp10152_Lab6 {

    static final int NUMBEROFGAMES = 10000;       //Declare number of games as final variable

    /**
     * Displays number of shots required in 1000 games
     */
    public static void startingSolution() {
        int totalShots = 0;                 //Initialize totalShots to 0
        System.out.println(BattleShip.version());
        for (int game = 0; game < NUMBEROFGAMES; game++) {

            BattleShip battleShip = new BattleShip();
            BattleShipBot battleBot = new BattleShipBot(battleShip);
            //SampleBot sampleBot = new SampleBot(battleShip);
            // Call SampleBot Fire randomly - You need to make this better!
            while (!battleShip.allSunk()) {
                battleBot.fireShot();
            }
            int gameShots = battleShip.totalShotsTaken();
            totalShots += gameShots;
        }
        System.out.printf("SampleBot - The Average # of Shots required in %d games to sink all Ships = %.2f\n", NUMBEROFGAMES, (double) totalShots / NUMBEROFGAMES);

    }

    /**
     * Main method to run the program
     * @param args 
     */
    public static void main(String[] args) {
        startingSolution();
    }

}
