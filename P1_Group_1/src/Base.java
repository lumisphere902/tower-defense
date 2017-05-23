import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class Base extends Actor {
	int health = 20;

	public Base() {
		setImage(new Image("file:base.png", 150, 150, false, false));
	}

	@Override
	public void act(long diff) {
		if (health <= 0) {
			getWorld().gameOver();
		}
	}

	public void attacked(int damage) {
//		System.out.println("I took damage!");
		health -= damage;
		((Label) ((VBox) getWorld().getHud().getChildren().get(1)).getChildren().get(1)).setText("Health: " + health);
	}

}
