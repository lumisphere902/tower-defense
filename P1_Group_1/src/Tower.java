
public abstract class Tower extends Actor {
	private int id;
	private int x;
	private int y;
	public Tower(int id, int x, int y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}
	public abstract void attack();
	public abstract void upgrade();
	public void sell() {
		
	}
}
