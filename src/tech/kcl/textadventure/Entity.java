package tech.kcl.textadventure;

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

	public void playerAttack(Entity enemy, Dice dice){
		int rollProb = dice.rollDice(3);
		int rollStatModifier = dice.rollDice(attack/2);
		if (rollProb == 0){
			System.out.println("your character feels stronger");
			System.out.println("Dice roll: " + rollStatModifier);
			enemy.setHp(enemy.getHp() - (attack + rollStatModifier));
		}else if (rollProb == 1 && attack > rollStatModifier){
			System.out.println("your character feels weaker");
			System.out.println("Dice roll: " + rollStatModifier);
			enemy.setHp(enemy.getHp() - (attack - rollStatModifier)); 			
		}else{
			enemy.setHp(enemy.getHp() - attack);
		}		
	}

	public void enemyAttack(Entity enemy, Dice dice, int sides){
		int rollProb = dice.rollDice(3);
		int rollStatModifier = dice.rollDice(block/2);
		
		if (rollProb == 0){
			if (enemy.getAttack() < rollStatModifier){
				System.out.println("your character feels stronger");
				System.out.println("Dice roll: " + rollStatModifier);
				hp -= enemy.getAttack() - block - rollStatModifier;
			}else{
				hp -= enemy.getAttack() - block; 
			}
		}else if (rollProb == 1){
			System.out.println("your character feels weaker");
			System.out.println("Dice roll: " + rollStatModifier);
			hp -= enemy.getAttack() - block + rollStatModifier; 
		}else{
			hp -= enemy.getAttack() - block;

		}
	}
	
	
	//getters and setters
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getHp() {
		return hp;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public int getStamina() {
		return stamina;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getAttack() {
		return attack;
	}

	public void setBlock(int block){
		this.block = block;	
	}
	
	public int getBlock() {
		return block;
	}	
}
