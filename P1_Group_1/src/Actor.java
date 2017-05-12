import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView {
	public Actor() {
	}

	public abstract void act(long diff);

	public void move(double dx, double dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}

	public World getWorld() {
		return (World) getParent();
	}

	public double getHeight() {
		return this.getImage().getHeight();
	}

	public double getWidth() {
		return this.getImage().getWidth();
	}

	public <A extends Actor> ArrayList<A> getIntersectingObjects(Class<A> cls) {
		ArrayList<A> ans = new ArrayList<A>();
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

	private boolean isIntersecting(double x1, double y1, double w1, double h1, double x2, double y2, double h2,
			double w2) {
		if (x1 + w1 >= x2 && x1 <= x2 + w2 && y1 + h1 > y2 && y1 <= y2 + h2) {
			return true;
		}
		return false;
	}
	
	public boolean isInGrid (int x, int y) {
		return true;
	}
}
