import javafx.scene.image.Image;

public class DoggoEnemy extends Enemy {
	private int health;
	
	public DoggoEnemy(){
		super(4);
		setImage(new Image("file:doggo.png", 50, 50, false, false));
		health = 40;
	}
	@Override
	public int getDamage() {
		return 10;
	}

	@Override
	public int getBounty() {
		return 50; 
	}

	@Override
	public void takeDamage(int damage) {
		health-=damage/2;
	}

	@Override
	public int getHealth() {
		return health;
	}

}
