package resources;

import com.badlogic.gdx.Gdx;

public interface Vars {

// pixels per meter
	public static final int R = 64;

// window
	public static final int w = Gdx.graphics.getWidth();
	public static final int h = Gdx.graphics.getHeight();

// category bits
	public static final short bBOUNDS = 2;    // 0000 0000 0000 0010
	public static final short bPLAYER = 16; // 0000 0000 0001 0000
	public static final short bENTITY = 32; // 0000 0000 0010 0000
}
