package entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import static entities.EntityManager.world;

class DynamicBody {

	private Body body;

	private static float w;
	private static float h;
	private static int R;

	private static short bBOUNDS;
	private static short bPLAYER;
	private static short bENTITY;

	private BodyDef bdef;
	private FixtureDef fdef;

	public DynamicBody () {
		bdef = new BodyDef();
		fdef = new FixtureDef();
	}

	public void setup (float width, float height, int R,
	                   int bBOUNDS, int bPLAYER, int bENTITY) {
		DynamicBody.w = width;
		DynamicBody.h = height;
		DynamicBody.R = R;
		DynamicBody.bBOUNDS = (short) bBOUNDS;
		DynamicBody.bPLAYER = (short) bPLAYER;
		DynamicBody.bENTITY = (short) bENTITY;
	}

	public void create (ID id, int size) {
		switch (id) {
			case Player:
				createPlayer(size);
				break;
		}
	}

	private void createPlayer (float size) {
		CircleShape circ = new CircleShape();
		bdef.type = BodyDef.BodyType.DynamicBody;
		fdef.shape = circ;
		fdef.filter.categoryBits = bPLAYER;
		fdef.filter.maskBits = (short) (bBOUNDS | bENTITY);
		fdef.isSensor = false;
		fdef.restitution = 1;

		bdef.position.set(w / 2 / R, h / 2 / R);
		body = world.createBody(bdef);
		circ.setRadius(size / R);
		body.createFixture(fdef).setUserData("P");
		body.setGravityScale(0);
	}

	public Body getBody () {
		return body;
	}
}
