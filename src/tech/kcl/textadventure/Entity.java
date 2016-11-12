package tech.kcl.textadventure;

import java.util.Random;

public class Entity {
	private int hp;
	private int stamina;
	private Inventory inventory;
	private int attack;
	private int block;
	
	public Entity(int hp, int stamina, Inventory inventory, int attack, int block){
	this.hp = hp;
	this.stamina = stamina;
	this.inventory = inventory;
	this.attack = attack;
	this.block = block;
	}

	public void death(){
		System.out.println("your hero has died");
		System.out.println("Game over");
	}
	
	public void playerAttack(Entity enemy, Dice dice, int sides){
		int roll = dice.rollDiceSilent(3);
		if (roll == 0){
			System.out.println("your character feels stronger");
			int roll2 = dice.rollDice(sides);
			enemy.decreaseHp(attack + roll2);
		}else if (roll == 1 && attack > roll2){
			System.out.println("your character feels weaker");
			int roll2 = dice.rollDice(sides);
			enemy.decreaseHp(attack - roll2); 
			
		}else{
			enemy.decreaseHp(attack);
		}		
	}

	public void enemyAttack(Entity enemy, Dice dice, int sides){
		int roll = dice.rollDiceSilent(3);
		
		if (roll == 0){
			System.out.println("your character feels stronger");
			int roll2 = dice.rollDice(sides);
			if (enemy.getStrength() < roll2){
				hp -= enemy.getStrength() - block - roll2;
					if (hp <= 0){
						death();
					}
			}else{
				hp -= enemy.getStrength() - block; 
			}
		}else if (roll == 1){
			System.out.println("your character feels weaker")
			int roll2 = dice.rollDice(sides);
			hp -= enemy.getStrength() - block + dice.rollDice(sides)); 
		}else{
			hp -= enemy.getStrength() - block;
		}
	}

	public void consume(Potion potion){
		System.out.println("your character feel refreshed")
		hp += potion.getValue();
	}

	public void moveLeft(){
		System.out.println("your character moved to left room")
		//add room object		
	}

	public void moveRight(){
		System.out.println("your character moved to right room")		
		//add room object
	}
	public void moveUp(){
		System.out.println("your character moved to upper room")		
		//add room object
	}
	
	
	public void decreaseHp(int num){
		hp -= num;
	}
	
	public void getStatus(){
		System.out.println("your current hp: " + getHp());
		System.out.println("your current stamina: " + getStamina());
		System.out.println("your current inventory status: " + getInventory());
		System.out.println("your current attack points: " + getInventory());
		System.out.println("your current block points: " + getBlock());
		System.out.println("Good luck hero, play safe.")
	}

	public int getHp() {
		return hp;
	}

	public int getStamina() {
		return stamina;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public int getAttack() {
		return attack;
	}

	public int getBlock() {
		return block;
	}
	
}
