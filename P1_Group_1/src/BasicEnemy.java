import javafx.scene.image.Image;

public class BasicEnemy extends Enemy {

	public BasicEnemy(int id) {
		super(id);
		Image image = new Image("file:basicEnemy.jpg", 50, 50, false, false);
		super.setImage(image);
	}

	@Override
	public void attacked(int damage) {
		System.out.println("I was hit!");
	}

}
