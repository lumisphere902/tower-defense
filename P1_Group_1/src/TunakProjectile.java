import javafx.scene.image.Image;

public class TunakProjectile extends Projectile{
	private int direction;
	
	public TunakProjectile(int id, double x, double y, Enemy e){
		super(id, x, y, 300, e);
		setImage(new Image("file:samosa.png", 20, 20, false, false));
	}
	@Override
	public void act(long diff) {
		move(Math.cos(direction), Math.sin(direction));
	}

}
