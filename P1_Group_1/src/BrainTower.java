import javafx.scene.image.Image;

public class BrainTower extends Tower{
	private long timer;
	
	public BrainTower(int id, int x, int y){
		super(id, x, y);
		super.setImage(new Image("file:brain.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false));
		timer = 0;
	}
	@Override
	public void attack(Enemy target) {
		
	}

	@Override
	public double getRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void act(long diff) {
		// TODO Auto-generated method stub
		
	}

}
