import javafx.scene.image.Image;

public class BasicEnemy extends Enemy {
	private int health = 10;
	public BasicEnemy() {
		super(0);
		Image image = new Image("file:basicEnemy.png", 50, 50, false, false);
		super.setImage(image);
	//	health = new HealthBar(this); 
	}

	@Override
	public int getDamage() {
		return 10;
	}

	@Override
	public int getBounty() {
		return 15;
	}

	@Override
	public void takeDamage(int damage) {
		health -= damage;
	}

	@Override
	public int getHealth() {
		return health;
	}
	
	public int getStartingHealth(){return 20;}

}
