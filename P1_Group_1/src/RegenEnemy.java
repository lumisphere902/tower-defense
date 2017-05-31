import javafx.scene.image.Image;

public class RegenEnemy extends Enemy {
	int health = 35;
	private long timer;
	
	public RegenEnemy() {
		super(2);
		setImage(new Image("file:arthur.png", 50, 50, false, false));
		timer = 0;
	}

	public void act(long diff){
		super.act(diff);
		System.out.println(health);
		timer += diff;
		if (timer > 500_000_000) {
			health++;
			timer %= 50_000_000;
		}
	}
	@Override
	public int getDamage() {
		return 3;
	}

	@Override
	public int getBounty() {
		return 10;
	}

	@Override
	public void takeDamage(int damage) {
		health -= damage;
	}

	@Override
	public int getHealth() {
		return health;
	}

}
