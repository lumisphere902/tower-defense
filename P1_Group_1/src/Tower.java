
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
	public void sell() {
		
	}
	public int Id() {
		return id;
	}
}
