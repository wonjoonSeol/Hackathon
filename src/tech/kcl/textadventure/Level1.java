package tech.kcl.textadventure;

public class Level1 extends Map {

	public Level1() {
		setRoom(new Room(new Food("Tacos", 20), new Entity(15, 5, 2, "Trump Soldier"), "Whiskey Room"), 0, 0);
		setRoom(new Room(), 1, 2);
		setRoom(new Room(), 2, 2);
	}
	
}
