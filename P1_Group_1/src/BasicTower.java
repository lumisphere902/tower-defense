
import javafx.scene.image.Image;

public class BasicTower extends Tower {
	private long timer;
	private static final int range = 300;
	public BasicTower(int x, int y) {
		super(0, x, y);
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		Projectile p = new BasicProjectile(getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public void act(long diff) {
		timer += diff;
		if (timer > 1_000_000_000) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}

	@Override
	public double getRange() {
		return range;
	}

}
