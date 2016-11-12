package tech.kcl.textadventure;

// The Main class where program execution begins
public class Main {
	
	// The commands variable is the instance of the Commands class that will be where command handling occurs
	private Commands commands;
	
	// Allows the program to be exited cleanly
	private boolean running;
	
	public Main() {
		// Initialise the commands object
		commands = new Commands(this);
	}
	
	public static void main(String[] args) {
		// Creates an object of the main class so that we don't have to reference stuff statically
		Main main = new Main();
		
		// Starts the program
		main.start();
	}
	
	public void start() {
		// Sets running to true so that the program can know when it is running and runs the program
		running = true;
		run();
	}
	
	public void run() {
		// Will repeat until the game has been stopped
		while (running) {
			commands.runNextCommand();
			
		}
	}
	
	public void stop() {
		// Stops the game by setting running to false
		running = false;
	}
}
