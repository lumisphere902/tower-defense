//replace this

import java.util.ArrayList;

import javafx.scene.image.Image;

public class GravityActor extends Actor {
	private double dx;
	private double dy;
	private int availableJumps;
	private int numJumped;
	private double currFriction;
	private boolean shouldApplyFriction = true;
	public static final int TYPE_MAIN_CHARACTER = 0;
	private boolean rightIsDown = false;
	private boolean leftIsDown = false;

	public GravityActor(int type, int numAvailableJumps, double x, double y) {
		super();
		initialize(type);
		this.availableJumps = numAvailableJumps;
		numJumped = 0;
		setX(x);
		setY(y);
	}

	private void initialize(int type) {
		String image = "";
		int width = 0;
		int height = 0;
		switch (type) {
		case TYPE_MAIN_CHARACTER:
			image = "file:happyFace.jpg";
			width = 64;
			height = 64;
			break;
		}
		Image img = new Image(image, width, height, false, false);
		setImage(img);
	}

	@Override
	public void act(long now) {
		if (leftIsDown()) {
			setDx(-5 + getCurrFriction());
			setShouldApplyFriction(false);
		}
		else if (rightIsDown()) {
			setDx(5 - getCurrFriction());
			setShouldApplyFriction(false);
		}
		else {
			setShouldApplyFriction(true);
		}
		move(dx, dy);
		checkCollisions();
		if (shouldApplyFriction) {
			applyFriction();
		}
	}

	private void checkCollisions() {
		ArrayList<StationaryActor> collisions = getIntersectingObjects(StationaryActor.class);
		for (StationaryActor a : collisions) {
			double thisMinX = getX();
			double thisMaxX = getX() + getWidth();
			double thisMinY = getY();
			double thisMaxY = getY() + getHeight();
			double aMinX = a.getX();
			double aMaxX = a.getX() + a.getWidth();
			double aMinY = a.getY();
			double aMaxY = a.getY() + a.getHeight();
			if (thisMinX < aMaxX && thisMaxX > aMaxX && thisMinY + 10 < aMaxY && thisMaxY - 10 > aMinY) {
				dx = Math.max(dx, 0);
				setX(aMaxX);
			} else if (thisMaxX > aMinX && thisMinX < aMinX && thisMinY + 10 < aMaxY && thisMaxY - 10 > aMinY) {
				dx = Math.min(dx, 0);
				setX(aMinX - getWidth() - 1);
			}
			if (thisMinY < aMaxY && thisMaxY > aMaxY && thisMinX + 10 < aMaxX && thisMaxX - 10 > aMinX) {
				dy = Math.max(dy, 0);
				setY(aMaxY);
			} else if (thisMaxY > aMinY && thisMinY < aMinY && thisMinX + 10 < aMaxX && thisMaxX - 10 > aMinX) {
				dy = Math.min(dy, 0);
				setY(aMinY - getHeight() - 1);
				currFriction = a.getFriction();
				numJumped = 0;
			}
		}
		stayInBounds();
	}

	private void applyFriction() {
		if (dx > 0) {
			dx = Math.max(0, dx - currFriction);
		} else {
			dx = Math.min(0, dx + currFriction);
		}
	}

	public void jump() {
		if (numJumped < availableJumps) {
			((GravityActor) ((GravityWorld) getWorld()).getMainCharacter()).setDy(-14);
			numJumped++;
			currFriction = 0;
		}
	}

	private void stayInBounds() {
		if (getX() < 0) {
			setX(0);
			dx = 0;
		}
		if (getX() + getWidth() > getWorld().getWidth()) {
			setX(getWorld().getWidth() - getWidth());
			dx = 0;
		}
		if (getY() < 0) {
			setY(0);
			dy = 0;
		}
		if (getY() + getHeight() > getWorld().getHeight()) {
			setY(getWorld().getHeight() - getHeight());
			dy = 0;
			numJumped = 0;
			currFriction = 0.1;
		}
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void changeDx(double delta) {
		this.dx += delta;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void changeDy(double delta) {
		this.dy += delta;
	}

	public boolean ShouldApplyFriction() {
		return shouldApplyFriction;
	}

	public double getCurrFriction() {
		return currFriction;
	}

	public void setCurrFriction(double currFriction) {
		this.currFriction = currFriction;
	}

	public void setShouldApplyFriction(boolean shouldApplyFriction) {
		this.shouldApplyFriction = shouldApplyFriction;
	}

	public boolean rightIsDown() {
		return rightIsDown;
	}

	public boolean leftIsDown() {
		return leftIsDown;
	}

	public boolean isRightIsDown() {
		return rightIsDown;
	}

	public void setRightIsDown(boolean rightIsDown) {
		this.rightIsDown = rightIsDown;
	}

	public boolean isLeftIsDown() {
		return leftIsDown;
	}

	public void setLeftIsDown(boolean leftIsDown) {
		this.leftIsDown = leftIsDown;
	}
}
