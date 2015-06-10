package handlers;

class KeyStates {

	static final int KEYCOUNT = 1;
	static final int ESCAPE = 0;

	static boolean[] keyStates = new boolean[KEYCOUNT];
	static int cursorX;
	static int cursorY;

	public static void setKey (int keycode, boolean state) {
		keyStates[keycode] = state;
	}

	public static boolean isDown (int keycode) {
		return keyStates[keycode];
	}
}
