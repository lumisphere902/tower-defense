import java.util.ArrayList;

import javafx.scene.image.Image;

public class TeleProjectile extends Projectile {
	private double direction;
	
	public TeleProjectile(int id, double x, double y, Enemy target) {
		super(id, x, y, 200, target);
		Image image = new Image("file:sunProjectile.png", 20, 20, false, false);
		setImage(image);
		direction = 2*Math.random()*Math.PI;
	}
	
	@Override
	public void act(long diff) {
		move(Math.cos(direction), Math.sin(direction));
		ArrayList<Enemy> enemies = getIntersectingObjects(Enemy.class);
		if (enemies.size()>0){
			for (Enemy e : enemies){
				e.attacked(1);
			}
		}
	}
	
}
