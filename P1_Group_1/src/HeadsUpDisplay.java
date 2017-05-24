import javafx.scene.control.Label;
<<<<<<< HEAD
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HeadsUpDisplay extends BorderPane {
	GridPane towers;
		
	public HeadsUpDisplay(){
		super();
		setStyle("-fx-background-color: #AAAAAA");
		setPrefHeight(100);
		towers = new GridPane();
		for (int i = 0; i < Constants.towerTypes.length; i++) {
			TowerData td = Constants.towerTypes[i];
			VBox tower = new VBox();
			ImageView img = new ImageView();
			img.setImage(new Image("file:"+td.getImage(),50,50,false,false));
=======
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HeadsUpDisplay extends BorderPane {
	GridPane towers;
		
	public HeadsUpDisplay(){
		super();
		setStyle("-fx-background-color: #AAAAAA");
		setPrefHeight(100);
		towers = new GridPane();
		for (int i = 0; i < Constants.towerTypes.length; i++) {
			TowerData td = Constants.towerTypes[i];
			VBox tower = new VBox();
			ImageView img = new ImageView();
			img.setImage(td.getImage());
>>>>>>> branch 'master' of https://lumisphere902@bitbucket.org/p1_group_1/p1_group_1_repo.git
			img.setX(0);
			img.setY(0);
			Label label = new Label("" + td.getCost());
			tower.getChildren().addAll(img, label);
			towers.add(tower, i, 0);
		}
		
		VBox nums = new VBox();
		Label moneyLabel = new Label("$0");
		Label healthLabel = new Label("Health: 20");
		nums.getChildren().addAll(moneyLabel, healthLabel);
		setLeft(towers);
		setRight(nums);
	}
	
}
