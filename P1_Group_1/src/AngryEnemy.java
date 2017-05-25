import javafx.scene.image.Image;

public class AngryEnemy extends Enemy{
	int health;
	
	public AngryEnemy(int id){
		super(id);
		super.setImage(new Image("file:nyan_animation.png", 50, 50, false, false));
		health = 200;
	}
	@Override
	public void attacked(int damage) {
		health -= damage;
	}

	@Override
	public int getDamage() {
		return 2;
	}
	@Override
	public int getBounty() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

}
