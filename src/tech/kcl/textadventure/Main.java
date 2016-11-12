package tech.kcl.textadventure;

public class Main {
	
	private Commands commands;
	private boolean running;
	
	public Main() {
		commands = new Commands(this);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		main.start();
	}
	
	public void start() {
		running = true;
	}
	
	public void run() {
		while (running) {
			commands.runNextCommand();
		}
	}
	
	public void stop() {
		running = false;
	}
}
