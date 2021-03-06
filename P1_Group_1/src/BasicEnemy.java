import javafx.scene.image.Image;

public class BasicEnemy extends Enemy {

	private int health = 15;

	public BasicEnemy() {
		super(0);
	}

	@Override
	public int getDamage() {
		return 1;
	}

	@Override
	public int getBounty() {
		return 15;
	}

	@Override
	public void takeDamage(int damage) {
		health -= damage;
	}

	public int getStartingHealth() {
		return 20;
	}

	public int getHealth() {
		return health;
	}

}
