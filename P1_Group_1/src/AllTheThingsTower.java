import javafx.scene.image.Image;

public class AllTheThingsTower extends Tower {
	private long timer;
	
	public AllTheThingsTower(int x, int y){
		super(4, x, y);
		timer = 0;
	}
	
	@Override
	public void attack(Enemy target) {
		Projectile p = new TorchProjectile(getX(), getY(), target);
		getWorld().add(p);
	}

	@Override
	public double getRange() {
		return 100;
	}

	@Override
	public void act(long diff) {
		timer += diff;
		if (timer > 300_000_000) {
			attack(findTarget());
			timer %= 300_000_000;
		}
	}
}
