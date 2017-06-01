import java.util.ArrayList;

import javafx.scene.image.Image;

public class SaltSpikes extends Projectile {
	private double direction;
	private int spikesLeft;
	
	public SaltSpikes(int id, double x, double y, Enemy target, double d){
		super(id, x, y, 200, target);
		this.direction = d;
		spikesLeft = 20;
		setImage(new Image("file:salt.png", 25, 25, false, false));
	}
	
	@Override
	public void act(long diff) {
		if (spikesLeft==0){getWorld().remove(this);}
		int yCoor = (int)(getY()/World.TILE_HEIGHT);
		int xCoor = (int)(getX()/World.TILE_WIDTH);
		if (xCoor<0||xCoor>=World.GRID_WIDTH||yCoor<0||yCoor>=World.GRID_HEIGHT){getWorld().remove(this);}
		//only move if its on buildable terrain, otherwise stop and sit there on path
		else if (getWorld().getBuildable()[yCoor][xCoor]){
			move(Math.cos(direction), Math.sin(direction));
		} 
		
		ArrayList<Enemy> enemies = getIntersectingObjects(Enemy.class);
		for (Enemy e: enemies){
			e.takeDamage(1);
			spikesLeft--;
		}
		
	}
	
}
