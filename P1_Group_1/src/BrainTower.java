import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BrainTower extends Tower{
	private long timer;
	
	public BrainTower(int id, int x, int y){
		super(id, x, y);
		super.setImage(new Image("file:brain.png", World.TILE_WIDTH, World.TILE_HEIGHT, false, false));
		timer = 0;
	}
	@Override
	public void attack(Enemy target) {
		GameWorld w = getWorld();
		if (w==null){return;}
		ImageView cover = new ImageView(new Image("file:brainExpanded.png", 450, 450, false, false));
		w.getChildren().add(cover);
		List<Enemy> allEnemies = w.getObjects(Enemy.class);
		for (int i=allEnemies.size()-1; i>=0; i--){
			w.getChildren().remove(allEnemies.get(i));
		}
	}

	@Override
	public double getRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void act(long diff) {
		timer += diff;
		long c = 10*1_000_000_000;
		if (timer > c) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
	}

}
