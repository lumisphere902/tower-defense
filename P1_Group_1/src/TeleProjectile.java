import java.util.ArrayList;

public class TeleProjectile extends Projectile {
	private double direction;
	
	public TeleProjectile(double x, double y, Enemy target) {
		super(2, x, y, 200, target);
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
