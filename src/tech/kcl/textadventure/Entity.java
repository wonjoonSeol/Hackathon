public class Entity {
	private int hp;
	private int stamina;
	private Inventory inventory;
	private int attack;
	private int block;

	Random r = new Random();
	
	public Entity(int hp, int block, int stamina, Inventory inventory, int attack, int block){
	this.hp = hp;
	this.stamina = stamina;
	this.inventory = inventory;
	this.attack = attack;
	this.block = block;
	}

	public attack(Entity enemy){
		enemy.decreaseHP(attack);
	}

	public block(){

	}

	public consume(){

	}

	public move(){

	}

	public



}
