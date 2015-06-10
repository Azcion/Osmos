package main;

import com.badlogic.gdx.Game;

public class CoreLauncher extends Game {

	Main main;
	public static final int W = 90;
	public static final int H = 60;
	public static final int SCALE = 16;

	@Override
	public void create () {
		setScreen(new Main(this));
	}
}
