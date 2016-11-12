package tech.kcl.textadventure;

public class Weapon extends Item {
	
private int damage;

	public Weapon(int damage) {
		this.damage = damage;
		
	}
	
	public int getWeapon() {
		return damage;
		
	}
}
