import javafx.scene.image.Image;

public class AngryEnemy extends Enemy{
	int health;
	
	public AngryEnemy(){
		super(0);
		super.setImage(new Image("file:cat.png", 50, 50, false, false));
		health = 50;
	}
	@Override
	public void act(long now){
		for (int i = 0; i<2; i++){super.act(now);}
	}
	
	@Override
	public int getDamage() {
		return 2;
	}
	@Override
	public int getBounty() {
		return 10;
	}
	@Override
	public void takeDamage(int damage) {
		health -= damage;
		
	}
	@Override
	public int getHealth() {
		return health;
	}

}
