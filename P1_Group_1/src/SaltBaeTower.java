import javafx.scene.image.Image;

public class SaltBaeTower extends Tower {

	public SaltBaeTower(int id, int x, int y){
		super(id, x, y);
		super.setImage(new Image("file:saltbae.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false));
		
	}
	@Override
	public void attack(Enemy target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		
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
