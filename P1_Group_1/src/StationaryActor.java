import javafx.scene.image.Image;

public class StationaryActor extends Actor {
	public double friction = 0;
	public static final int TYPE_BRICK_PLATFORM = 0;
	public StationaryActor(int type, double x, double y) {
		super();
		initialize(type);
		setX(x);
		setY(y);
	}
	@Override
	public void act(long now) {}
	
	private void initialize(int type) {
		String image = "";
		int width = 0;
		int height = 0;
		switch (type) {
		case TYPE_BRICK_PLATFORM:
			image = "file:brickBlock.png";
			width = 200;
			height = 100;
			this.friction = .5;
			break;
		}
		Image img = new Image(image, width, height, false, false);
		setImage(img);
	}
	public double getFriction() {
		return friction;
	}

}
