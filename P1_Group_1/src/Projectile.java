
public abstract class Projectile extends Actor {
	private int id;
	private Enemy target;
	private int speed;
	
	public Projectile(int id, double x, double y, int speed, Enemy target) {
		super();
		this.id = id;
		setX(x);
		setY(y);
		this.target = target;
		this.speed = speed;
	}

	public Enemy getTarget() {
		return target;
	}

	public int getSpeed() {
		return speed;
	}

}
