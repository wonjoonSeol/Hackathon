package tech.kcl.textadventure;

public class Weapon extends Item {
	
	private int damage;

	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
		
	}
	
	public int getWeapon() {
		return damage;
		
	}
}
