import java.util.ArrayList;

import javafx.scene.image.Image;

public class SaltSpikes extends Projectile {
	private double direction;
	private int spikesLeft;
	
	public SaltSpikes(double x, double y, Enemy target, double d){
		super(6, x, y, 200, target);
		this.direction = d;
		spikesLeft = 20;
	}
	
	@Override
	public void act(long diff) {
		if (getTarget() == null) {
			getWorld().remove(this);
			return;
		}
		if (spikesLeft==0){getWorld().remove(this);}
		int yCoor = (int)(getY()/World.TILE_HEIGHT);
		int xCoor = (int)(getX()/World.TILE_WIDTH);
		if (xCoor<0||xCoor>=World.GRID_HEIGHT||yCoor<0||yCoor>=World.GRID_WIDTH){getWorld().remove(this);return;}
		//only move if its on buildable terrain, otherwise stop and sit there on path
		GameWorld w = getWorld();
		if (w!=null){
			boolean[][] buildable = w.getBuildable();
			boolean p = buildable[xCoor][yCoor];
			if (p){
				move(Math.cos(direction), Math.sin(direction));
			} 
		}

		ArrayList<Enemy> enemies = getIntersectingObjects(Enemy.class);
		if (enemies!=null&&enemies.size()!=0){
			for (Enemy e: enemies){
				e.takeDamage(1);
				spikesLeft--;
			}
		}
		
	}
	
}
