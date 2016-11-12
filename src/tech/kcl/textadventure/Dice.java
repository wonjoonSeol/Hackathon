package tech.kcl.textadventure;

import java.util.Random;

public class Dice {

	private static Random rand = new Random();
	
	public int rollDice(int nSides) {
        return rand.nextInt(nSides)+1;
	}
}
/*
Roll is:  4
Roll is:  1
Roll is:  2
Total is: 7
*/
