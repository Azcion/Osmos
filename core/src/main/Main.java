package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import entities.EntityManager;
import handlers.ContactHandler;
import handlers.Controls;

import static entities.EntityManager.world;
import static resources.Vars.*;

public class Main implements Screen {

	private SpriteBatch batch;

	private OrthographicCamera camera;
	private Box2DDebugRenderer debugc;

	protected EntityManager eManager;

	public Main () {
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		debugc = new Box2DDebugRenderer();
		camera.setToOrtho(false, w / R, h / R);

		eManager = new EntityManager();
		world = new World(new Vector2(0, 0), false);
		world.setContactListener(new ContactHandler());
		eManager.setup(w, h, R, bBOUNDS, bPLAYER, bENTITY);
		eManager.create();
	}

	private void update (float delta) {
		camera.update();
		eManager.update();
		Controls.update(eManager.getPlayer());

		world.step(delta, 6, 2);
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(.04f, 0f, .13f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update(1/60f);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			// TODO
		batch.end();

	// debug view
		debugc.render(world, camera.combined);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
