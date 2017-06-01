
public abstract class Projectile extends Actor {
	private int id;
	private int speed;
	private Enemy target;
	
	public Projectile(int id, double x, double y, int speed, Enemy e) {
		super();
		this.id = id;
		setX(x);
		setY(y);
		this.speed = speed;
		target = e;
	}

	public int getID(){
		return id;
	}

	public int getSpeed() {
		return speed;
	}
	public Enemy getTarget() {
		return target;
	}

}
