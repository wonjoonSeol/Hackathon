package tech.kcl.textadventure;


// food extends the items class, only has getters
// can only set during construction
public class Food extends Item implements Consumable {
	private int hp;
	
	public Food(String name, int hp) {
		super(name);
		this.hp = hp;
	}
	
	public void setFood(int hp) {
		this.hp = hp;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void consume(Entity entity) {
		entity.setHp(entity.getHp() + hp);
	}
}
