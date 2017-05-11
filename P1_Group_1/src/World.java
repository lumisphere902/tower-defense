import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public abstract class World extends Pane {
	private AnimationTimer	timer;
//	private World world = this;
	public World() {
		timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				act(System.nanoTime());
				for (Node a : getChildren()) {
					((Actor) a).act(System.nanoTime());
				}
			}
		};
//		setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				System.out.println("ASDF");
//			}
//		});
//		sceneProperty().addListener(new ChangeListener<Scene>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
//				if (newValue == null) {
//					return;
//				}
//				newValue.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//
//					@Override
//					public void handle(KeyEvent event) {
//						System.out.println("KEY PRESSED");
//						world.getOnKeyPressed().handle(event);
//						for (Actor a : getObjects(Actor.class)) {
//							if (a.getOnKeyPressed() == null) {
//								return;
//							}
//							a.getOnKeyPressed().handle(event);
//						}
//					}
//				});
//				observable.getValue().addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
//
//					@Override
//					public void handle(KeyEvent event) {
//						System.out.println("KEY RELEASED");
//						for (Actor a : getObjects(Actor.class)) {
//							if (a.getOnKeyReleased() == null) {
//								return;
//							}
//							a.getOnKeyReleased().handle(event);
//						}
//					}
//					
//				});
//			}
//		});
	}
	public abstract void act (long now);
	public void start() {
		timer.start();
	}
	public void stop() {
		timer.stop();
	}
	public void add (Actor a) {
		getChildren().add(a);
	}
	public void remove(Actor a) {
		getChildren().remove(a);
	}
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
