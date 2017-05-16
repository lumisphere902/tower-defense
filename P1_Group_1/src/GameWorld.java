

public class GameWorld extends World {
	private Tower[][] grid;
	public GameWorld() {
		super();
		grid = new Tower[GRID_WIDTH][GRID_HEIGHT];
	}
	@Override
	public void act(long now) {
	}
	public void addTower (Tower a, int x, int y) {
		if (getTower(x,y) != null) {
			return;
		}
//		a.setX(x*TILE_WIDTH);
//		a.setY(y*TILE_HEIGHT);
		getChildren().add(a);
		grid[x][y] = a;
	}
	public Tower getTower (int x, int y) {
		return grid[x][y];
	}

}
