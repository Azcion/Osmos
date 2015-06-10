package main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	public static void main (String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Osmos";
		cfg.width = CoreLauncher.W * CoreLauncher.SCALE;
		cfg.height = CoreLauncher.H * CoreLauncher.SCALE;
		cfg.resizable = true;
		new LwjglApplication(new CoreLauncher(), cfg);
	}
}
