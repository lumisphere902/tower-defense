import javafx.scene.image.Image;

public class TorchProjectile extends Projectile{
	
	private int damage = 10;
	
	public TorchProjectile(int id, double x, double y, Enemy target){
		super(id, x, y, 200, target);
		setImage(new Image("file:torch.png", 25, 25, false, false));
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
			((Enemy) getTarget()).attacked(damage);
			getWorld().remove(this);
		}
	}

}
