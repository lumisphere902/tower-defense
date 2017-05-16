
public abstract class Projectile extends Actor {
	private int id;
	private Actor target;
	private int speed;
	
	public Projectile(int id, double x, double y, int speed, Actor target) {
		super();
		this.id = id;
		setX(x);
		setY(y);
		this.target = target;
		this.speed = speed;
	}

	public Actor getTarget() {
		return target;
	}

	public int getSpeed() {
		return speed;
	}

}
