package tech.kcl.textadventure;


/**
* the player "exists" in this room. Maps are composed of rooms
*/
public class Room {
	private Item item;
	private Entity entity;
	private String roomMessage;
	
	public Room(Item item, Entity entity, String roomMessage) {
		this.Item = item;
		this.entity = entity;
		this.roomMessage = roomMessage;
		
	}
	
	public Room(Item item, String roomMessage) {
		this.Item = item;
		this.roomMessage = roomMessage;
		
	}
	
	public Room(Entity entity, String roomMessage) {
		this.entity = entity;
		this.roomMessage = roomMessage;
		
	}
	
	// empty constructor
	public Room(String roomMessage){
		this.roomMessage = roomMessage;
	}
	
	
}