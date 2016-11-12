package tech.kcl.textadventure;


// food extends the items class, only has getters
// can only set during construction
public class Food extends Item {
	private int hp;
	private int stamina;

	public Food(int hp, int stamina) {
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
}
