
//replace this

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
		VBox root = new VBox();
		root.setMinHeight( World.GRID_HEIGHT * World.TILE_HEIGHT + 100);
		GameWorld world = new GameWorld();
		world.addTower(new BasicTower(0, 5, 5), 5, 5);
		world.spawnEnemy(new BasicEnemy(0), 0);
		HBox hud = new HBox();
		hud.setAlignment(Pos.BOTTOM_LEFT);
//		hud.setBackground(new Background(new BackgroundFill(new Color, arg1, arg2)));
		GridPane towers = new GridPane();
		for (int i = 0; i < Constants.towerTypes.length; i++) {
			TowerData td = Constants.towerTypes[i];
			VBox tower = new VBox();
//			System.out.println(td.getImage().getWidth());
			ImageView img = new ImageView();
			img.setImage(td.getImage());
			img.setX(0);
			img.setY(0);
			Label label = new Label("" + td.getCost());
			tower.getChildren().addAll(img, label);
			towers.add(tower, i, 0);
		}
		VBox nums = new VBox();
		Label moneyLabel = new Label("$");
		nums.getChildren().addAll(moneyLabel);
		hud.getChildren().addAll(towers, nums);
		root.getChildren().addAll(world, hud);
		Scene scene = new Scene(root, World.GRID_WIDTH * World.TILE_WIDTH, World.GRID_HEIGHT * World.TILE_HEIGHT + 100);
		stage.setScene(scene);
		stage.show();
		world.start();
	}
}
