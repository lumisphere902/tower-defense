import javafx.scene.image.Image;

public class AoeTower extends Tower {
	private long timer;
	private static final int range = 500;

	public AoeTower(int id, int x, int y) {
		super(id, x, y);
		Image image = new Image("file:aoeTower.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false);
		super.setImage(image);
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		Projectile p = new AoeProjectile(0, getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getRange() {
		// TODO Auto-generated method stub
		return range ;
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
