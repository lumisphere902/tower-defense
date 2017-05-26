import java.util.ArrayList;

import javafx.scene.image.Image;

public class TeleProjectile extends Projectile {

	public TeleProjectile(int id, double x, double y, Enemy target) {
		super(id, x, y, 200, target);
		Image image = new Image("file:sunProjectile.png", 20, 20, false, false);
		setImage(image);
	}
	
	@Override
	public void act(long diff) {
		if (Math.random()<0.01){move(1, 0);}
		ArrayList<Enemy> enemies = getIntersectingObjects(Enemy.class);
		while (enemies.size()>0){
			for (Enemy e : enemies){
				e.attacked(5);
			}
		}
	}
	
}
