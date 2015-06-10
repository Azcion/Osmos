package entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import static entities.EntityManager.world;

class StaticBody {

	private static float w;
	private static float h;
	private static int R;

	private static short bBOUNDS;
	private static short bPLAYER;
	private static short bENTITY;

	private BodyDef bdef;
	private FixtureDef fdef;

	public StaticBody () {
		bdef = new BodyDef();
		fdef = new FixtureDef();
	}

	public void setup (float width, float height, int R,
	                   int bBOUNDS, int bPLAYER, int bENTITY) {
		StaticBody.w = width;
		StaticBody.h = height;
		StaticBody.R = R;
		StaticBody.bBOUNDS = (short) bBOUNDS;
		StaticBody.bPLAYER = (short) bPLAYER;
		StaticBody.bENTITY = (short) bENTITY;
	}

	public void create (ID id) {
		switch(id) {
			case Bounds: createBounds(); break;
		}
	}

	private void createBounds () {
		PolygonShape rect = new PolygonShape();
		bdef.type = BodyDef.BodyType.StaticBody;
		fdef.shape = rect;
		fdef.filter.categoryBits = bBOUNDS;
		fdef.filter.maskBits = (short) (bPLAYER | bENTITY);
		fdef.isSensor = false;

		float[] xc = {w / 2, w / 2, 0, w};
		float[] yc = {0, h, h / 2, h / 2};

		for (int i = 0; i < 4; ++i) {
			switch (i) {
				case 0: rect.setAsBox(h / 2 / R, 1 / R); break;
				case 2: rect.setAsBox(1 / R, w / 2 / R); break;
			}
			bdef.position.set(xc[i]/R, yc[i]/R);
			Body body = world.createBody(bdef);
			body.createFixture(fdef).setUserData("W-" + i);
		}
	}
}
