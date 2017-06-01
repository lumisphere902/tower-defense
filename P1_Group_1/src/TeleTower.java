import javafx.scene.image.Image;

public class TeleTower extends Tower {
	private long timer;
	private static final int range = 500;

	public TeleTower(int id, int x, int y) {
		super(id, x, y);
		Image image = new Image("file:teletubbies.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false);
		super.setImage(image);
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		TeleProjectile p = new TeleProjectile(0, getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public double getRange() {
		return range;
	}

	@Override
	public void act(long diff) {
		timer += diff;
		if (timer/1_000_000 > 7500) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}
}
