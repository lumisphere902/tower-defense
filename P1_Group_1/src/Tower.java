
public abstract class Tower extends Actor {
	private int id;
	private int type;
	private int x;
	private int y;
	public Tower(int id, int type, int x, int y) {
		super();
		this.id = id;
		this.type = type;
		this.x = x;
		this.y = y;
	}
	public abstract void attack();
	public void upgrade() {
		
	}
	public void sell() {
		
	}
}
