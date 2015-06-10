package entities;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class EntityManager {

	public static World world;

	private StaticBody bounds;
	private Entity player;
	private Array<Entity> mobArr;

	public EntityManager () {
		bounds = new StaticBody();
		player = new Entity(30, ID.Player);
		mobArr = new Array<>();
	}

	public void update () {
		// TODO
	}

	public void setup (float width, float height, int R,
	                   int bBOUNDS, int bPLAYER, int bENTITY) {
		Entity.R = R;
		bounds.setup(width, height, R, bBOUNDS, bPLAYER, bENTITY);
		player.body.setup(width, height, R, bBOUNDS, bPLAYER, bENTITY);
	}

	public void create () {
		bounds.create(ID.Bounds);
		player.create();
	}

	public Entity getPlayer () {
		return player;
	}
}
