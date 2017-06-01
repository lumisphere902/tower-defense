import javafx.scene.image.Image;

public class BrainTower extends Tower{
	private long timer;
	
	public BrainTower(int x, int y){
		super(5, x, y);
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
