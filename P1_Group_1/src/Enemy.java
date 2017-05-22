
public abstract class Enemy extends Actor {
	private int id;
	private int distance;
	
	public Enemy(int id) {
		super();
		this.id = id;
	}
	
	public abstract void attacked (int damage);

	@Override
	public void act(long now) {
		distance++;
		move(-1, 0);
		if (getX() < 0) {
			getWorld().remove(this);
		}
	}

	public int getDistance() {
		return distance;
	}

}
