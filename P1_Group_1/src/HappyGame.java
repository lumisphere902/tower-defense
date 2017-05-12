
//replace this

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
		stage.setTitle("Tower Defense Game");
		stage.setResizable(false);
		stage.sizeToScene();
		StackPane root = new StackPane();
		GameWorld world = new GameWorld();
		root.getChildren().add(world);
		Scene scene = new Scene(root, World.GRID_WIDTH * World.TILE_WIDTH, World.GRID_HEIGHT * World.TILE_HEIGHT);
		stage.setScene(scene);
		stage.show();
		world.addTower(new BasicTower(0, 5, 5), 5, 5);
		world.addTower(new BasicTower(1, 20, 10), 20, 10);
		world.start();
	}

}
