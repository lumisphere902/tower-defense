import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class World extends Pane {

	public static final int TILE_WIDTH = 25;
	public static final int TILE_HEIGHT = 25;
	public static final int GRID_WIDTH = 20;
	public static final int GRID_HEIGHT = 18;

	private long lastTime = System.nanoTime();
	private AnimationTimer timer;

	public World() {
		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				long time = System.nanoTime();
				act(time - lastTime);
				for (int i = 0; i < getChildren().size(); i++) {
					Node a = getChildren().get(i);
					try {
						if (!Actor.class.isInstance(a)) {
							((Act) a).act(time - lastTime);
						} else {
							((Actor) a).act(time - lastTime);
						}
					} catch (ClassCastException e){;}

				}
				lastTime = time;
			}
		};
	}

	public abstract void act(long now);

	public void start() {
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	public void add(Actor a) {
		getChildren().add(a);
	}

	public void remove(Actor a) {
		getChildren().remove(a);
	}

	@SuppressWarnings("unchecked")
	public <A extends Actor> List<A> getObjects(java.lang.Class<A> cls) {
		ArrayList<A> list = new ArrayList<A>();
		for (Node a : getChildren()) {
			if (cls.isInstance(a)) {
				list.add((A) a);
			}
		}
		return list;
	}
}
