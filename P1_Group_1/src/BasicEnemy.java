import javafx.scene.image.Image;

public class BasicEnemy extends Enemy {
	private int health = 10;
	public BasicEnemy(int id) {
		super(id);
		Image image = new Image("file:basicEnemy.jpg", 50, 50, false, false);
		super.setImage(image);
	}

	@Override
	public void attacked(int damage) {
		health -= damage;
		System.out.println("I was hit!");
		if (health <= 0) {
			getWorld().remove(this);
			System.out.println("I died!");
		}
	}

}
