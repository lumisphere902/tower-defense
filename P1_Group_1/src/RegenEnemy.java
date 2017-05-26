import javafx.scene.image.Image;

public class RegenEnemy extends Enemy {
	int health = 35;
	
	public RegenEnemy() {
		super(2);
		setImage(new Image("file:arthur.png", 50, 50, false, false));
	}

	public void act(long now){
		super.act(now);
		System.out.println(health);
		if (Math.random()<0.01){health++;}
	}
	@Override
	public int getDamage() {
		return 5;
	}

	@Override
	public int getBounty() {
		return 20;
	}

	@Override
	public void takeDamage(int damage) {
		health -= damage + 1;
	}

	@Override
	public int getHealth() {
		return health;
	}

}
