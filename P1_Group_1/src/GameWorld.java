

public class GameWorld extends World {
	private Tower[][] grid;
	private static final int[][] spawnPositions = {{300,300}};
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
		add(a);
		grid[x][y] = a;
	}
	public Tower getTower (int x, int y) {
		return grid[x][y];
	}
	public void spawnEnemy (Enemy e, int spawnPosition) {
		e.setX(spawnPositions[spawnPosition][0]);
		e.setY(spawnPositions[spawnPosition][1]);
		add(e);
	}

}
