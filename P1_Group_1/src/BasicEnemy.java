import javafx.scene.image.Image;

public class BasicEnemy extends Enemy {
	
	private int health = 200000;

	public BasicEnemy(int id) {
		super(id);
		Image image = new Image("file:basicEnemy.png", 50, 50, false, false);
		super.setImage(image);
	//	health = new HealthBar(this); 
	}

	@Override
	public void attacked(int damage) {
		health -= damage;
		System.out.println("I was hit!");
		if (health <= 0 && getWorld() != null) {
			getWorld().remove(this);
			System.out.println("I died!");
		}
	}

	@Override
	public int getDamage() {
		return 10;
	}
	
	public int getStartingHealth(){return 20;}
	public int getHealth(){return health;}

}
