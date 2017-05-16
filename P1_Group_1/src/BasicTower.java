import javafx.scene.image.Image;

public class BasicTower extends Tower {
	private long timer;
	private static final int range = 500;
	public BasicTower(int id, int x, int y) {
		super(id, x, y);
		Image image = new Image("file:basicTower.jpg", World.GRID_WIDTH, World.GRID_HEIGHT, false, false);
		super.setImage(image);
		timer = 0;
	}

	@Override
	public void attack(Actor target) {
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
		if (Id() == 1) {
			move(-3,0);
			return;
		}
		timer += diff;
		if (timer > 1000000000) {
			attack(getWorld().getTower(20, 10));
			timer %= 1000000000;
		}
	}

	@Override
	public double getRange() {
		// TODO Auto-generated method stub
		return range;
	}

}
