


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
		Scene scene = new Scene(root, World.GRID_WIDTH * World.TILE_WIDTH, World.GRID_HEIGHT * World.TILE_HEIGHT + 100);

		world.setPrefSize(World.GRID_WIDTH * World.TILE_WIDTH, World.GRID_HEIGHT * World.TILE_HEIGHT);
		world.setStyle("-fx-background-color: #FFFFFF");
		BorderPane hud = new BorderPane();
		hud.setStyle("-fx-background-color: #AAAAAA");
		hud.setPrefHeight(100);
		FlowPane towers = new FlowPane();
		for (int i = 0; i < Constants.towerTypes.length; i++) {
			TowerData td = Constants.towerTypes[i];
			VBox tower = new VBox();
			// System.out.println(td.getImage().getWidth());
			ImageView img = new ImageView();
			img.setImage(td.getImage());
			img.setX(0);
			img.setY(0);
			Label label = new Label("" + td.getCost());
			tower.getChildren().addAll(img, label);
			final int num = i;
			tower.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if (world.getMoney() < Constants.towerTypes[num].getCost()) {
						return;
					}
//					ImageView imgView = ((ImageView) tower.getChildren().get(0));
					world.setCurrTower(num);
					world.setTowerImg(Constants.towerTypes[num].getImage());
					scene.setCursor(new ImageCursor(Constants.towerTypes[num].getThumbnail()));
				}
			});
			towers.getChildren().add(tower);
		}
		VBox nums = new VBox();
		Label moneyLabel = new Label("$0");
		Label healthLabel = new Label("Health: 20");
		//Button nextGen = new Button("Next Wave");
		//nextGen.setOnAction(e->world.nextWave());
		nums.getChildren().addAll(moneyLabel, healthLabel);
		hud.setLeft(towers);
		hud.setRight(nums);
		root.setTop(world);
		root.setBottom(hud);
		stage.setScene(scene);
		stage.show();
		world.setHud(hud);
		world.start();
	}
}
