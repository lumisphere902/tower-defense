import javafx.scene.image.Image;

public class BasicProjectile extends Projectile {

	public BasicProjectile(int id, double x, double y, Actor target) {
		super(id, x, y, 200, target);
		Image image = new Image("file:basicProjectile.jpg", 10, 10, false, false);
		super.setImage(image);
	}

	@Override
	public void act(long diff) {
		double xSpeed = (getTarget().getX() - super.getX());
		double ySpeed = (getTarget().getY() - super.getY());
		double speedFactor = getSpeed() / Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed);
		super.move(xSpeed * speedFactor * diff/1000000000,
				ySpeed * speedFactor * diff/1000000000);
	}
}
