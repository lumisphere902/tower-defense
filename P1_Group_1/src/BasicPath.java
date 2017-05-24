
public class BasicPath extends Path {
	private boolean right, horizontal;

	public BasicPath(Enemy e) {
		super(e);
		horizontal = false;
		right = false;
		// direction = Math.random()*Math.PI*2;
	}

	public void nextMove() {
//		System.out.println(e.getY());
		if (e.getX() < 0) {
			horizontal = false;
			e.move(1, 1);
		} else if (e.getX() > e.getWorld().getWidth() - e.getWidth()) {
			horizontal = false;
			e.move(-1, 1);
		}

		if (e.getY() % 100 == 0) {
			horizontal = true;
			if (e.getY() % 200 == 0) {
				right = false;
			} else {
				right = true;
			}
		}

		if (horizontal) {
			if (right) {
				e.move(1, 0);
			} else {
				e.move(-1, 0);
			}
		} else {
			e.move(0, 1);
		}

		/*
		 * e.move(Math.cos(direction), Math.sin(direction));
		 * 
		 * else if (e.getX()<0){direction = Math.PI - direction;} if
		 * (e.getY()<0){direction = - direction;} else if
		 * (e.getY()>e.getWorld().getHeight()){direction = - direction;} if
		 * (Math.random()<0.001){direction = Math.random()*Math.PI*2;}
		 */
	}
}
