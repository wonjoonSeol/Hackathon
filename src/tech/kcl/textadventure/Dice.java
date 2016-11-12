package tech.kcl.textadventure;

import java.util.Random;

public class Dice {
	private int scale;	//only if you want to add more complexity in game, currently not implemented
	
	private static Random rand = new Random();
	
	public int rollDice(int nSides) {
        return rand.nextInt(nSides)+1;
	}
	
	public int getScale(){
		return scale;
	}
	
	public void setScale(int scale){
		this.scale = scale;
	}
}
/*
Roll is:  4
Roll is:  1
Roll is:  2
Total is: 7
*/
