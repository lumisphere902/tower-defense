import java.util.ArrayList;

import javafx.scene.image.Image;

public class TunakProjectile extends Projectile{
	private double direction;
	
	public TunakProjectile(double x, double y, double d, Enemy target){
		super(3, x, y, 300, target);
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
