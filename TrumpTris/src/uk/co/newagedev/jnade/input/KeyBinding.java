package uk.co.newagedev.jnade.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBinding implements KeyListener {
	
	private static final int KEYBOARD_SIZE = 1024;

	private static Map<String, Integer> keyBindings = new HashMap<String, Integer>();

	private static boolean[] pressing = new boolean[KEYBOARD_SIZE];
	
	private static boolean[] down = new boolean[KEYBOARD_SIZE];
	
	private static boolean[] releasing = new boolean[KEYBOARD_SIZE];
	
	private static boolean[] awtDown = new boolean[KEYBOARD_SIZE];

	public static void bindKey(String function, int key) {
		keyBindings.put(function, key);
	}

	public static void removeBinding(String function) {
		keyBindings.remove(function);
	}

	public static void changeBinding(String function, int newKey) {
		keyBindings.put(function, newKey);
	}

	public static boolean isKeyDuplicated(String function) {
		int count = 0;
		for (String key : keyBindings.keySet()) {
			if (function.equalsIgnoreCase(key)) {
				count += 1;
			}
		}
		return count > 1;
	}

	public static int getBinding(String function) {
		return keyBindings.get(function);
	}

	public static void update() {
		for (int i = 0; i < KEYBOARD_SIZE; i++) {
			boolean kd = awtDown[i];
			if (!pressing[i] && !down[i] && kd) {
				pressing[i] = true;
			} else if (pressing[i] && !down[i] && kd) {
				pressing[i] = false;
				down[i] = true;
			} else if (down[i] && !releasing[i] && !kd) {
				down[i] = false;
				releasing[i] = true;
			} else if (!down[i] && releasing[i] && !kd) {
				releasing[i] = false;
			}

			if (pressing[i] && releasing[i]) {
				releasing[i] = false;
			}
			if (releasing[i] && down[i]) {
				down[i] = false;
			}
			if (pressing[i] && down[i]) {
				down[i] = false;
			}
		}
	}

	public static boolean isKeyDown(String function) {
		int id = getBinding(function);
		return down[id];
	}
	
	public static boolean isKeyPressing(String function) {
		int id = getBinding(function);
		return pressing[id];
	}

	public static boolean isKeyReleasing(String function) {
		int id = getBinding(function);
		return releasing[id];
	}

	public static List<Integer> getKeysPressing() {
		List<Integer> keys = new ArrayList<Integer>();
		for (int i = 0; i < pressing.length; i++) {
			if (pressing[i]) {
				keys.add(i);
			}
		}
		return keys;
	}
	
	public static List<Integer> getKeysDown() {
		List<Integer> keys = new ArrayList<Integer>();
		for (int i = 0; i < down.length; i++) {
			if (down[i]) {
				keys.add(i);
			}
		}
		return keys;
	}
	
	public static List<Integer> getKeysReleasing() {
		List<Integer> keys = new ArrayList<Integer>();
		for (int i = 0; i < releasing.length; i++) {
			if (releasing[i]) {
				keys.add(i);
			}
		}
		return keys;
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		awtDown[ke.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		awtDown[ke.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent ke) {}
}
