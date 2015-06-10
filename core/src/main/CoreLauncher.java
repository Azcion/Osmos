package main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import handlers.InputHandler;

public class CoreLauncher extends Game {

	Main main;
	public static final int W = 90;
	public static final int H = 60;
	public static final int SCALE = 16;

	@Override
	public void create () {
		Gdx.input.setInputProcessor(new InputHandler());
		setScreen(new Main());
	}
}
