
//replace this


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
		BorderPane root = new BorderPane();
		GameWorld world = new GameWorld();
		world.setPrefSize(World.GRID_WIDTH * World.TILE_WIDTH, World.GRID_HEIGHT * World.TILE_HEIGHT);
		world.addTower(new BasicTower(0, 5, 5), 5, 5);
		world.spawnEnemy(new BasicEnemy(0), 0);
		world.setStyle("-fx-background-color: #FFFFFF");
		HeadsUpDisplay hud = new HeadsUpDisplay();
		root.setTop(world);
		root.setBottom(hud);
		Scene scene = new Scene(root, World.GRID_WIDTH * World.TILE_WIDTH, World.GRID_HEIGHT * World.TILE_HEIGHT + 100);
		stage.setScene(scene);
		stage.show();
		world.setHud(hud);
		world.start();
	}
}
