package tech.kcl.textadventure;

public class Map {
	private Room[][] rooms;
	private int x;
	private int y;
	
	public Map() {
		rooms = new Room[10][10];
	}
	public void setRoom(Room room, int x, int y) {
		rooms[x][y] = room; 
	}
	
	public void move(int x, int y) {
		this.x+= x;
		this.y += y;
	}
	public int[] getCurrentRoom() {
		return new int[]{x, y};
	}
	
	public Room getRoom(int x, int y) {
		return rooms[x][y];
	}
	public Room getCurrentRoomObject() {
		return rooms[x][y];
	}

}
