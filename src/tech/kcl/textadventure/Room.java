package tech.kcl.textadventure;


/**
* the player "exists" in this room. Maps are composed of rooms
*/
public class Room {
	private Item item;
	private Entity entity;
	private String roomMessage;
	
	public Room(Item item, Entity entity, String roomMessage) {
		this.item = item;
		this.entity = entity;
		this.roomMessage = roomMessage;
		
	}
	
	public Room(Item item, String roomMessage) {
		this.item = item;
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
	
	public String getDescription() {
		return roomMessage;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	
}
