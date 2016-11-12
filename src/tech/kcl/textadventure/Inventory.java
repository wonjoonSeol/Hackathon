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
	
	public Item[] getItems() {
		return (Item[]) items.toArray();
	}
}
