package tech.kcl.textadventure;

public class Level1 extends Map {

	public Level1() {
		setRoom(new Room(new Food("Tacos", 20), new Entity(15, 5, 2, "Trump Soldier"), "Whiskey Room"), 0, 0);
		setRoom(new Room(new Food("Trash", 0), new Entity(5, 2, 2, "Trump Minion"), "Rose room"), 1, 0);
		setRoom(new Room(new Food("Guacamole", 5), new Entity(10, 4, 2, "Trump Recruit"), "Gin Room"), 2, 0);
		setRoom(new Room(new Food("Trash", 0), new Entity(15, 5, 2, "Trump Soldier"), "Vodka Room"), 3, 0);
		setRoom(new Room(new Food("Guacamole", 5), new Entity(15, 5, 2, "Trump Soldier"), "Red Wine Room"), 4, 0);
		setRoom(new Room(new Food("Tacos", 20), new Entity(5, 2, 2, "Trump Minion"), "Narrow Corridor"), 3, 1);
		setRoom(new Room(new Food("Tacos", 20), new Entity(15, 5, 2, "Trump Soldier"), "Tequilla Room"), 3, 2);
		setRoom(new Room(new Food("Guacamole", 5), new Entity(15, 5, 2, "Trump Soldier"), "Small Damp Room"), 4, 2);
		setRoom(new Room(new Food("Tacos", 20), new Entity(15, 5, 2, "Trump Soldier"), "Rose Room"), 5, 2);
		setRoom(new Room(new Food("Tacos", 20), new Entity(15, 5, 2, "Trump Soldier"), "White wine Room"), 6, 2);
		setRoom(new Room(new Food("Guacamole", 5), new Entity(15, 5, 2, "President Trump"), "Boss"), 6, 1);
		setRoom(new Room(new Food("Tacos", 20), new Entity(0, 1, 0, "Goal"), "Goal"), 6, 0);
	}
	
}
