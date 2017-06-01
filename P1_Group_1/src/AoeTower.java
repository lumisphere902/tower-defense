import javafx.scene.image.Image;

public class AoeTower extends Tower {
	private long timer;
	private static final int range = 500;

	public AoeTower(int x, int y) {
		super(1, x, y);
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		Projectile p = new AoeProjectile(getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public double getRange() {
		return range ;
	}

	@Override
	public void act(long diff) {
		timer += diff;
		if (timer > 1_500_000_000) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}

}
