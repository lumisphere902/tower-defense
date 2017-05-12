//replace this

import javafx.scene.Node;

public class GravityWorld extends World {

	private Actor mainCharacter;
	private double gravity;
	
	public GravityWorld(double gravity) {
		super();
		this.gravity = gravity;
	}

	@Override
	public void act(long now) {
		for (Node a : getChildren()) {
			if (a.getClass().equals(GravityActor.class)) {
				((GravityActor)a).changeDy(gravity);
			}
		}
	}

	public Actor getMainCharacter() {
		return mainCharacter;
	}

	public void setMainCharacter(Actor mainCharacter) {
		this.mainCharacter = mainCharacter;
	}

}
