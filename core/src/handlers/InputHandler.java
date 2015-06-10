package handlers;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputHandler extends KeyStates implements InputProcessor {

	@Override
	public boolean keyDown (int keycode) {
		switch (keycode) {
			case Keys.ESCAPE:
				setKey(ESCAPE, true);
				break;
		}
		return keycode < KEYCOUNT;
	}

	@Override
	public boolean keyUp (int keycode) {
		switch (keycode) {
			case Keys.ESCAPE:
				setKey(ESCAPE, false);
				break;
		}
		return keycode < KEYCOUNT;
	}

	@Override
	public boolean mouseMoved (int screenX, int screenY) {
		cursorX = screenX;
		cursorY = screenY;
		return true;
	}

	@Override
	public boolean touchDown (int screenX, int screenY, int pointer, int button) {
		switch (button) {
			case Buttons.LEFT:
				setKey(MOUSEL, true);
				break;
			case Buttons.RIGHT:
				setKey(MOUSER, true);
				break;
			case Buttons.MIDDLE:
				setKey(MOUSEM, true);
				break;
		}
		return true;
	}

	@Override
	public boolean touchUp (int screenX, int screenY, int pointer, int button) {
		switch (button) {
			case Buttons.LEFT:
				setKey(MOUSEL, false);
				break;
			case Buttons.RIGHT:
				setKey(MOUSER, false);
				break;
			case Buttons.MIDDLE:
				setKey(MOUSEM, false);
				break;
		}
		return true;
	}

	@Override
	public boolean touchDragged (int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean scrolled (int amount) {
		return false;
	}

	@Override
	public boolean keyTyped (char character) {
		return false;
	}
}
