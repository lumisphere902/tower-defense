
public abstract class Enemy extends Actor {
	private int id;
	private int distance;
	private Path path;
	boolean right, horizontal;
	
	public Enemy(int id) {
		super();
		this.id = id;
		horizontal = true; right = true; 
		path = new BasicPath(this);
	}
	
	public abstract void attacked (int damage);
	
	/**
	 * Move along a path
	 */
	@Override
	public void act(long now) {
		distance++;
		path.nextMove();
		
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
