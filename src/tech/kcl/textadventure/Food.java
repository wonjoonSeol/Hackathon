package tech.kcl.textadventure;


// food extends the items class, only has getters
// can only set during construction
public class Food extends Item implements Consumable {
	private int hp;
	private int stamina;
	
	public Food(String name, int hp, int stamina) {
		super(name);
		this.hp = hp;
		this.stamina = stamina;
	}
	
	public void setFood(int hp) {
		this.hp = hp;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public void consume(Entity entity) {
		entity.setHp(entity.getHp() + hp);
		entity.setStamina(entity.getStamina() + stamina);
	}
}
