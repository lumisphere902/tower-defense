
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
		Base base = getWorld().getBase();
		if (isIntersecting(getX(), getY(), getWidth(), getHeight(), base.getX(), base.getY(), base.getHeight(), base.getWidth())) {
			base.attacked(getDamage());
			getWorld().remove(this);
		}
	}

	public abstract int getDamage();

	public int getDistance() {
		return distance;
	}

}
