package tech.kcl.textadventure;

public class Potion extends Item {
	private int hp;
	private int stamina;
	private int attack;
	private int block;

	public Potion(int hp, int stamina, int attack, int block) {
		this.hp = hp;
		this.stamina = stamina;
		this.attack = attack;
		this.block = block;
		
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getBlock() {
		return block;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getStamina() {
		return stamina;
	}
}
