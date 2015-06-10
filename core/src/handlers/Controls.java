package handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import entities.Entity;

public class Controls extends KeyStates {

	public static void update (Entity player) {

		if (isDown(ESCAPE)) {
			Gdx.app.exit();
		}

		Vector2 p = player.getBody().getPosition();
		Vector2 c = new Vector2(cursorX / Entity.R, cursorY / Entity.R);

		float angleA = (float) Math.atan2(c.y - p.y, c.x - p.x);
		player.getBody().setTransform(p.x, p.y, p.angle() - angleA - 2.25f);
	}
}
