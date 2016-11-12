package tech.kcl.textadventure;

import java.util.Scanner;

public class Commands {

	private Main main;
	private Scanner scanner;
	
	public Commands(Main main) {
		this.main = main;
		scanner = new Scanner(System.in);
	}
	
	public void exit() {
		scanner.close();
		main.stop();
	}

	public void runNextCommand() {
		System.out.println("> ");
		String command = scanner.next().toLowerCase();
		
		String[] commandParts = command.split(" ");
		
		switch (commandParts[0]) {
		case "search":
			break;
		default:
			System.out.println("Sorry that command is invalid, please try again!");
			runNextCommand();
		}
	}
}
