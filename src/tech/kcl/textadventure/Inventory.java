package tech.kcl.textadventure;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Item> items;
	
	public Inventory() {
		items = new ArrayList<Item>();
	}
	
	public void addItemToInventory(Item item) {
		items.add(item);
	}
	
	public void removeItemFromInventory(Item item) {
		items.remove(item);
	}
	
	public Item[] getItems() {
		return items.toArray(new Item[] {});
	}
}
