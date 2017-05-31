import javafx.scene.image.Image;

public class NyanCatEnemy extends Enemy {
	int health;

	public NyanCatEnemy() {
		super(1);
		super.setImage(new Image("file:cat2.gif", 50, 50, false, false));
		health = 50;
	}

	@Override
	public void act(long now) {
		for (int i = 0; i < 2; i++) {
			setDistance(getDistance() + 1);
			getPath().nextMove();
		}

		Base base = getWorld().getBase();
		if (isIntersecting(getX(), getY(), getWidth(), getHeight(), base.getX(), base.getY(), base.getHeight(),
				base.getWidth())) {
			base.attacked(getDamage());
			getWorld().remove(this);
		}
	}

	@Override
	public int getDamage() {
		return 2;
	}

	@Override
	public int getBounty() {
		return 20;
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
