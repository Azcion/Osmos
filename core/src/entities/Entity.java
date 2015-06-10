package entities;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Entity extends Actor {

	private static int baseAt;

	protected int base;
	protected ID id;
	protected int size;
	protected boolean canGrow;
	protected boolean hasAI;
	protected int modifier;

	public Entity (int size, ID id) {
		base = baseAt++;
		this.id = id;
		body = new DynamicBody();
		skin = new Skin();
		this.size = size;

		constructEntity();
	}

	private void constructEntity () {
		switch (id) {
			case Player:
				canGrow = true;
				modifier = 0;
				break;
			case Standard:
			case Attractor:
				canGrow = true;
				hasAI = false;
				modifier = 1;
				break;
			case Antimatter:
				canGrow = true;
				hasAI = false;
				modifier = -1;
				break;
			case Nemocyte:
			case Ferax:
			case Ovarium:
				canGrow = true;
				hasAI = true;
				modifier = 1;
				break;
			case Repulsor:
				canGrow = false;
				hasAI = true;
				modifier = 0;
				break;
		}
	}

	public void create () {
		body.create(id);
	}
}
