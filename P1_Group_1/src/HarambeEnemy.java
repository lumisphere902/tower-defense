public class HarambeEnemy extends Enemy {
	private int health;
	
	public HarambeEnemy(){
		super(3);
		health = 50;
	}
	@Override
	public int getDamage() {
		return 5;
	}

	@Override
	public int getBounty() {
		return 40;
	}

	@Override
	public void takeDamage(int damage) {
		health-=damage;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}
	
}
