import javafx.scene.image.Image;

public class DoggoEnemy extends Enemy {
	private int health;
	
	public DoggoEnemy(){
		super(4);
		health = 80;
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
		health-=damage;
		if (Math.random()<0.1){health++;}
	}

	@Override
	public int getHealth() {
		return health;
	}

}
