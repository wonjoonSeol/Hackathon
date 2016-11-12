package tech.kcl.textadventure;

import java.util.Scanner;

public class Commands {

	private Main main;
	private Map map;
	private Entity player;
	private Scanner scanner;
	private boolean fighting = true;

	public Commands(Main main) {
		this.main = main;
		player = new Entity(100, 5, 10, "Jose");
		player.getInventory().addItemToInventory(new Weapon("Rolling Pin", 10));
		map = new Level1();
		scanner = new Scanner(System.in);
	}

	public void exit() {
		scanner.close();
		main.stop();
	}

	public boolean go(String[] commandParts) {
		int[] loc = map.getCurrentRoom();
		if (commandParts[1].equalsIgnoreCase("west")) {
			if (loc[0] == 0)
				return false;
			if (map.getRoom(loc[0] - 1, loc[1]) == null)
				return false;
			map.move(-1, 0);
		} else if (commandParts[1].equalsIgnoreCase("east")) {
			if (loc[0] == 9)
				return false;
			if (map.getRoom(loc[0] + 1, loc[1]) == null)
				return false;
			map.move(1, 0);
		} else if (commandParts[1].equalsIgnoreCase("north")) {
			if (loc[1] == 0)
				return false;
			if (map.getRoom(loc[0], loc[1] - 1) == null)
				return false;
			map.move(0, -1);
		} else if (commandParts[1].equalsIgnoreCase("south")) {
			if (loc[1] == 9)
				return false;
			if (map.getRoom(loc[0], loc[1] + 1) == null)
				return false;
			map.move(0, 1);
		}
		
		if (loc[0] == map.getCurrentRoom()[0] && loc[1] == map.getCurrentRoom()[1]) {
			System.out.println("You are staying in the same room");
		} else {
			System.out.println("You are now entering the " + map.getCurrentRoomObject().getDescription());
		}
		
		int[] newLoc = map.getCurrentRoom();
		boolean entityPresent = map.getRoom(newLoc[0], newLoc[1]).getEntity() != null;
		
		if (!fighting && entityPresent) {
			int option = -1;
			System.out.println("Oh noes! An enemy has appeared! Would you like to 1. fight or 2. flight? ");
			option = scanner.nextInt();
			while (!(option == 1 || option == 2)) {
				System.out.println("Sorry that isn't an option, please enter a valid option: ");
				option = scanner.nextInt();
				scanner.nextLine();
			}
			fighting = option == 1;
			
			System.out.println("So you want to run away? let's see about that...");
			Dice dice = new Dice();
			int roll = dice.rollDice(20);
			if (roll > 15) {
				System.out.println("Looks like you were able to run away. You are very lucky...");
				map.move(loc[0] - newLoc[0], loc[1] - newLoc[1]);
			} else {
				fighting = true;
				System.out.println("Aww so unlucky! now you have to fight!");
			}
		} else if (fighting) {
			System.out.println("Sorry you can't run away you are currently fighthing");
		}
		
		return true;
	}

	public void search() {
		System.out.println("You are now entering the " + map.getCurrentRoomObject().getDescription());
		if (map.getCurrentRoomObject().getEntity() != null) {
			System.out.println("There is an enemy called " + map.getCurrentRoomObject().getEntity().getName());
		}
		if (map.getCurrentRoomObject().getItem() != null) {
			String itemType = "";
			if (map.getCurrentRoomObject().getItem() instanceof Potion) {
				itemType = "a potion";
			} else if (map.getCurrentRoomObject().getItem() instanceof Food) {
				itemType = ((Food) map.getCurrentRoomObject().getItem()).getName();
			}
			System.out.println("You picked up " + itemType);
			player.getInventory().addItemToInventory(map.getCurrentRoomObject().getItem());
			map.getCurrentRoomObject().setItem(null);
		}
		if (map.getCurrentRoomObject().getEntity() == null && map.getCurrentRoomObject().getEntity() == null) {
			System.out.println("The room is empty");
		}
	}
	
	public boolean use(String item) {
		for (Item itemObj : player.getInventory().getItems()) {
			if (itemObj.getName().equalsIgnoreCase(item)) {
				if (itemObj instanceof Consumable) {
					((Consumable) itemObj).consume(player);
					System.out.println("You just consumed " + item);
					player.getInventory().removeItemFromInventory(itemObj);
					return true;
				} else {
					System.out.println("Sorry you cannot consume " + item);
					return true;
				}
			}
		}
		System.out.println("Sorry you do not own an object called " + item);
		return false;
	}
	
	public void attack() {
		Dice dice = new Dice();
		if (fighting) {
			map.getCurrentRoomObject().getEntity().playerAttack(map.getCurrentRoomObject().getEntity(), dice);
			map.getCurrentRoomObject().getEntity().enemyAttack(map.getCurrentRoomObject().getEntity(), dice);
			if (map.getCurrentRoomObject().getEntity().getHp() < 0) {
				System.out.println("Successfully killed " + map.getCurrentRoomObject().getEntity().getName());
				fighting = false;
				map.getCurrentRoomObject().setEntity(null);
			}
		}
	}
	
	public void help() {
		System.out.println("The available commands are:\nGO direction - moves the player in that direction\nINVENTORY - outputs the contents of your inventory\nSEARCH - tells you about your surroundings\nATTACK - attacks the enemy if there is one\nBLOCK - blocks against the enemy attack\nUSE item - will use the item in your inventory");
	}
	
	public void inventory() {
		System.out.println("Your inventory contains: ");
		String line = "";
		for (Item item : player.getInventory().getItems()) {
			line += item.getName() + ", ";
		}
		line = line.substring(0, line.length() - 2);
		System.out.println(line);
	}
	
	public void runNextCommand() {
		System.out.println("> ");
		String command = scanner.nextLine().toLowerCase();

		String[] commandParts = command.split(" ");

		switch (commandParts[0]) {
		case "go":
			boolean succeeded = go(commandParts);
			if (!succeeded)
				System.out.println("Sorry you can't go " + commandParts[1]);
			break;
		case "search":
			search();
			break;
		case "inventory":
			inventory();
			break;
		case "help":
			help();
			break;
		case "attack":
			attack();
			break;
		case "use":
			if (commandParts.length == 1) help();
			else use(commandParts[1]);
			break;
		default:
			System.out.println("Sorry that command is invalid, please try again!");
			runNextCommand();
		}
	}
}
