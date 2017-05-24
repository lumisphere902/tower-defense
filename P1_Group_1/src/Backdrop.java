import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class Backdrop extends FlowPane{
	
	public Backdrop(GameWorld gw){
	

		boolean[][] buildable = gw.getBuildable();
		for (boolean[] row : buildable){
			for (boolean tile : row){
				if (tile){
					ImageView turf = new ImageView(new Image("file:turf.jpg"));
					turf.setFitHeight(25);turf.setFitWidth(25);
					getChildren().add(turf);
				} else{
					ImageView road = new ImageView(new Image("file:rainbowsquare.jpg"));
					road.setFitHeight(25);road.setFitWidth(25);
					getChildren().add(road);
				}
			}
		}
	}
}
