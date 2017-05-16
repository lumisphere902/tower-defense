
public abstract class Enemy extends Actor {
	private int id;
	private int type;
	private int entrance; //Where it spawns, should be stored in world
	private int distance;
	
	public Enemy(int id, int type, int entrance) {
		super();
		this.id = id;
		this.type = type;
		this.entrance = entrance;
	}
	
	public void attacked (int damage) {
		
	}

	@Override
	public void act(long now) {
		distance++;
	}

	public int getDistance() {
		return distance;
	}

}
