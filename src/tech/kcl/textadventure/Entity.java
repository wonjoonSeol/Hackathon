import java.util.Random;

public class Entity {
	private int hp;
	private int stamina;
	private Inventory inventory;
	private int attack;
	private int block;
	
	public Entity(int hp, int block, int stamina, Inventory inventory, int attack, int block){
	this.hp = hp;
	this.stamina = stamina;
	this.inventory = inventory;
	this.attack = attack;
	this.block = block;
	}

	public attack(Entity enemy, Dice dice, int sides){
		int roll = 0;
		roll = r.nextInt(3);
		
		if (roll = 0){
			System.out.println("your character feels stronger");
			enemy.decreaseHP(attack) + dice.rollDice(sides);
		}else if (roll = 1){
			System.out.println("your character feels weaker")
			enemy.decreaseHP(attack- dice.rollDice(sides)); 
		}else{
			enemy.deceraseeHP(attack);
		}		
	}

	public block(Entity enemy){
		int roll = 0;
		roll = r.nextInt(3);
		
		if (roll = 0){
			System.out.println("your character feels stronger");
			roll = dice.rollDice(sides);
			if (enemy.getStrength() < roll){
				hp -= enemy.getStrength() - roll;
			}else{
				hp -= enemy.getStrength(); 
			}
		}else if (roll = 1){
			System.out.println("your character feels weaker")
			enemy.decreaseHP(block - dice.rollDice(sides)); 
		}else{
			enemy.decreaseHP(block);
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
	
	public int getStrength(){
		return strength;
	}
	public int getBlock(){
		return strength;
	}
	public int getStrength(){
		return strength;
	}
	public int getStrength(){
		return strength;
	}
	public int getStrength(){
		return strength;
	}
	
}
