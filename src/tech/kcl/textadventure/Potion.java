package tech.kcl.textadventure;

public class Potion extends Item implements Consumable {
	private int hp;
	private int attack;
	private int block;

	public Potion(String name, int hp, int attack, int block) {
		super(name);
		this.hp = hp;
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
	
	public void consume(Entity entity) {
		entity.setAttack(entity.getAttack() + attack);
		entity.setBlock(entity.getBlock() + block);
		entity.setHp(entity.getHp() + hp);
	}
}
