import javafx.scene.image.Image;

public class AoeProjectile extends Projectile {

	private int damage = 4;

	public AoeProjectile(int id, double x, double y, Enemy target) {
		super(id, x, y, 200, target);
		Image image = new Image("file:aoeProjectile.png", 20, 20, false, false);
		setImage(image);
	}

	@Override
	public void act(long diff) {
		if (getTarget() == null) {
			getWorld().remove(this);
			return;
		}
		double xSpeed = (getTarget().getCenterX() - (getWidth() / 2) - super.getX());
		double ySpeed = (getTarget().getCenterY() - (getHeight() / 2) - super.getY());
		double speedFactor = getSpeed() / Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed);
		super.move(xSpeed * speedFactor * diff / 1000000000, ySpeed * speedFactor * diff / 1000000000);
		if (isIntersecting(getX(), getY(), getWidth(), getHeight(), getTarget().getX(), getTarget().getY(),
				getTarget().getHeight(), getTarget().getWidth())) {
			int gridX = (int) (getTarget().getX() / World.TILE_WIDTH);
			int gridY = (int) (getTarget().getY() / World.TILE_HEIGHT);
			for (Enemy e : getWorld().getObjects(Enemy.class)) {
				if (isIntersecting((gridX - 1) * World.TILE_WIDTH, (gridY - 1) * World.TILE_HEIGHT, World.TILE_WIDTH * 4,
						World.TILE_HEIGHT * 4, e.getX(), e.getY(), e.getHeight(), e.getWidth())) {
					e.attacked(damage);
				}
			}
			RagDoll r = new RagDoll();
			r.setImage(new Image("file:aoeProjectile.png", World.TILE_WIDTH * 4, World.TILE_HEIGHT * 4, false, false));
			r.setX((gridX - 1) * World.TILE_WIDTH);
			r.setY((gridY - 1) * World.TILE_HEIGHT);
			getWorld().add(r);
			getWorld().remove(this);
		}
	}

}
