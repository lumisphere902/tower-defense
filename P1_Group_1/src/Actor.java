
// import packages
import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView {
	public Actor() {
	}

	public abstract void act(long diff);

	public void move(double dx, double dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}

	public GameWorld getWorld() {
		return (GameWorld) getParent();
	}

	public double getHeight() {
		return this.getImage().getHeight();
	}

	public double getWidth() {
		return this.getImage().getWidth();
	}

	public double getCenterX() {
		return super.getX() + getWidth() / 2.0;
	}

	public double getCenterY() {
		return super.getY() + getHeight() / 2.0;
	}

	public <A extends Actor> ArrayList<A> getIntersectingObjects(Class<A> cls) {
		ArrayList<A> ans = new ArrayList<A>();
		GameWorld w = getWorld(); if(w==null){return ans;}
		for (Actor a : getWorld().getObjects(cls)) {
			if (isIntersecting(getX(), getY(), getWidth(), getHeight(), a.getX(), a.getY(), a.getHeight(),
					a.getWidth())) {
				ans.add((A) a);
			}
		}
		return ans;
	}

	public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
		for (Actor a : getWorld().getObjects(cls)) {
			if (isIntersecting(getX(), getY(), getWidth(), getHeight(), a.getX(), a.getY(), a.getHeight(),
					a.getWidth())) {
				return (A) a;
			}
		}
		return null;
	}

	public boolean isIntersecting(double x1, double y1, double w1, double h1, double x2, double y2, double h2,
			double w2) {
		if (x1 + w1 >= x2 && x1 <= x2 + w2 && y1 + h1 > y2 && y1 <= y2 + h2) {
			return true;
		}
		return false;
	}

	public boolean isInGrid(int x, int y) {
		return true;
	}

	public double getDistance(Actor a) {
		return new Point2D(getX(), getY()).distance(new Point2D(a.getX(), a.getY()));
	}
}