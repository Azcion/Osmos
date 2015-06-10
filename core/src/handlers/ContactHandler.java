package handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ContactHandler implements ContactListener {

	@Override
	public void beginContact (Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		String[] ua = fa.getUserData().toString().split("-");
		String[] ub = fb.getUserData().toString().split("-");

		// TODO
	}

	@Override
	public void endContact (Contact contact) {
		// TODO
	}

	@Override
	public void preSolve (Contact contact, Manifold oldManifold) {
		// TODO
	}

	@Override
	public void postSolve (Contact contact, ContactImpulse impulse) {
		// TODO
	}
}
