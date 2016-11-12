package tech.kcl.textadventure;

public class Map {
	private Room[][] rooms;
	
	public Map() {
		rooms = new Room[10][10];
	}
	public void setRoom(Room room, int x, int y) {
		rooms[x][y] = room; 
	}

}
