import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BrainTower extends Tower{
	private long timer;
	boolean coverOn = false;
	ImageView cover;
	GameWorld w;
	
	public BrainTower(int x, int y){
		super(5, x, y);
		timer = 0;
	}
	@Override
	public void attack(Enemy target) {
		w = getWorld();
		if (w==null){return;}
		cover = new ImageView(new Image("file:brainExpanded.png", 500, 450, false, false));
		w.getChildren().add(cover);
		coverOn=true;
		List<Enemy> allEnemies = w.getObjects(Enemy.class);
		for (int i=allEnemies.size()-1; i>=0; i--){
			w.getChildren().remove(allEnemies.get(i));
		}
	}

	@Override
	public double getRange() {
		return 100;
	}

	@Override
	public void act(long diff) {
		if (coverOn){
			try{Thread.sleep(1000);}catch(InterruptedException e){;}
			w.getChildren().remove(cover);
			coverOn=false;
		}
		
		timer += diff;
		long c = 1_000_000_000;
		c*=30;//how many seconds
		if (timer > c) {
			attack(findTarget());
			timer %= 1_000_000_000;
		}
		
	}

}
