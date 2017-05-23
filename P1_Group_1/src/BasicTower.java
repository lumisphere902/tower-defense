import javafx.scene.image.Image;

public class BasicTower extends Tower {
	private long timer;
	private static final int range = 1000;
	public BasicTower(int id, int x, int y) {
		super(id, x, y);
		Image image = new Image("file:basicTower.png", World.GRID_WIDTH, World.GRID_HEIGHT, false, false);
		super.setImage(image);
		timer = 0;
	}

	@Override
	public void attack(Enemy target) {
		Projectile p = new BasicProjectile(0, getX(), getY(), target);
//		System.out.println(getX());
//		System.out.println(getY());
		getWorld().add(p);
//		System.out.println(getWorld().getChildren());
//		System.out.println("ADDED PROJECTILE");
	}

	@Override
	public void upgrade() {
		System.out.println("Upgrade!");
	}

	@Override
	public void act(long diff) {
//		System.out.println("Act!");
//		System.out.println(getWorld());
		timer += diff;
		if (timer > 1000000000) {
			attack(findTarget());
			timer %= 1000000000;
		}
	}

	@Override
	public double getRange() {
		// TODO Auto-generated method stub
		return range;
	}

}
