
import javafx.scene.image.Image;

public class BasicTower extends Tower {
	private long timer;
	private static final int range = 300;
	public BasicTower(int id, int x, int y) {
		super(id, x, y);
		Image image = new Image("file:basicTower.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false);
		super.setImage(image);
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		Projectile p = new BasicProjectile(0, getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public void upgrade() {
//		System.out.println("Upgrade!");
	}

	@Override
	public void act(long diff) {
//		System.out.println("Act!");
//		System.out.println(getWorld());
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
