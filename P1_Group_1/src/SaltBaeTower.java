import javafx.scene.image.Image;

public class SaltBaeTower extends Tower {
	private long timer = 0;
	
	public SaltBaeTower(int id, int x, int y){
		super(id, x, y);
		super.setImage(new Image("file:saltbae.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false));
		
	}
	@Override
	public void attack(Enemy target) {
		getWorld().add(new SaltSpikes(0, getX(), getY(), target, 2*Math.random()*Math.PI));
	}

	@Override
	public double getRange() {
		return 100;
	}

	@Override
	public void act(long diff) {
		timer+=diff;
		if (timer/1_000_000 > 1500) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}
	
}
