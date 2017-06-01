import java.util.ArrayList;

import javafx.scene.image.Image;

public class TunakProjectile extends Projectile{
	private double direction;
	
	public TunakProjectile(int id, double x, double y, double d, Enemy target){
		super(id, x, y, 300, target);
		setImage(new Image("file:samosa.png", 20, 20, false, false));
		direction = d;
	}
	
	@Override
	public void act(long diff) {
		move(3*Math.cos(direction), 3*Math.sin(direction));
		if (Math.random()<0.1){
			ArrayList<Enemy> enemies = getIntersectingObjects(Enemy.class);
			if (enemies.size()>0){
				for (Enemy e : enemies){
					e.attacked(1);
				}
			}
		}
	}
	
	public double getDirection(){
		return direction;
	}

}
