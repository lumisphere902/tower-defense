
public abstract class Tower extends Actor {
	private int id;
	public Tower(int id, int x, int y) {
		super();
		this.id = id;
		setX(x*World.TILE_WIDTH);
		setY(y*World.TILE_HEIGHT);
	}
	public abstract void attack(Actor target);
	public abstract void upgrade();
	public abstract double getRange();
	public void sell() {
		
	}
	public int Id() {
		return id;
	}
	Enemy findTarget() {
		double maxDist = 0;
		Enemy max = null;
		for (Enemy e : getWorld().getObjects(Enemy.class)) {
			if (getDistance(e) < getRange() && e.getDistance() > maxDist) {
				maxDist = e.getDistance();
				max = e;
			}
		}
		return max;
	}
}
