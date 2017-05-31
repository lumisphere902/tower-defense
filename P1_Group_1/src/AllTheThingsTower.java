import javafx.scene.image.Image;

public class AllTheThingsTower extends Tower {
	private long timer;
	
	public AllTheThingsTower(int id, int x, int y){
		super(id, x, y);
		super.setImage(new Image("file:allThings.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false));
		timer = 0;
	}
	
	@Override
	public void attack(Enemy target) {
		
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public double getRange() {
		return 100;
	}

	@Override
	public void act(long diff) {
		
	}

}
