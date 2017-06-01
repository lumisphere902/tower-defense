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
		double ran = Math.random()*2*Math.PI/3;
		for (int i = 0; i<3; i++){
			TunakProjectile p = new TunakProjectile(0,getX(), getY(), 2*Math.PI*i/3 + ran, target);
			getWorld().add(p);
		}
	}
	
	@Override
	public double getRange() {
		return 40;
	}

	@Override
	public void act(long diff) {
		timer += diff;
		if (timer/1_000_000 > 9000) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}

}
