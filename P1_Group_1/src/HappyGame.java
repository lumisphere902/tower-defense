//replace this

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HappyGame extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Happy Game");
		stage.setResizable(false);
		stage.sizeToScene();
		StackPane root = new StackPane();
		GravityWorld world = new GravityWorld(0.4);
		root.getChildren().add(world);
		Scene scene = new Scene(root, 1000, 600);
		stage.setScene(scene);
		stage.show();
		GravityActor mainCharacter = new GravityActor(GravityActor.TYPE_MAIN_CHARACTER, 2, world.getWidth() / 2 - 32,
				world.getHeight() / 2 - 32);
		mainCharacter.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				KeyCode code = event.getCode();
				GravityActor character = (GravityActor) world.getMainCharacter();
				if (code.equals(KeyCode.W)) {
					character.jump();
				}
				if (code.equals(KeyCode.A)) {
					character.setLeftIsDown(true);
					
				} else if (code.equals(KeyCode.D)) {
					character.setRightIsDown(true);
				}
			}
		});
		mainCharacter.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				KeyCode code = event.getCode();
				GravityActor character = ((GravityActor) world.getMainCharacter());
				if (code.equals(KeyCode.A)) {
					character.setLeftIsDown(false);
					
				} else if (code.equals(KeyCode.D)) {
					character.setRightIsDown(false);
				}
			}
			
		});
		world.add(mainCharacter);
		world.setMainCharacter(mainCharacter);
		StationaryActor platform1 = new StationaryActor(StationaryActor.TYPE_BRICK_PLATFORM, 400, 300);
		world.add(platform1);
		world.start();
	}

}
