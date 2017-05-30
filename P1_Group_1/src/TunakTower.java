import javafx.scene.image.Image;

public class TunakTower extends Tower {
	private long timer;
	
	public TunakTower(int id, int x, int y) {
		super(id, x, y);
		super.setImage(new Image("file:tunak.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false));
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		Projectile p = new AoeProjectile(0, getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public void upgrade() {
		;
	}

	@Override
	public double getRange() {
		return 40;
	}

	@Override
	public void act(long diff) {
		timer += diff;
		if (timer/1_000_000 > 1500) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}

}
