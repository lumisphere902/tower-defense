
public class GameWorld extends World {
	private Tower[][] grid;
	private static final int[][] spawnPositions = { { 300, 300 } };
	private int nextWave = 0;
	private int[] toSpawn = new int[1];
	private long[] timers = new long[1];

	public GameWorld() {
		super();
		grid = new Tower[GRID_WIDTH][GRID_HEIGHT];
	}

	@Override
	public void act(long diff) {
		boolean toNextWave = true;
		for (int i = 0; i < toSpawn.length; i++) {
			if (toSpawn[i] != 0) {
				toNextWave = false;
			}
		}
		if (toNextWave) {
			System.out.println("WAVE DONE");
			newWave(nextWave);
			return;
		}
		for (int i = 0; i < toSpawn.length; i++) {
			timers[i] += diff;
		}
		for (int i = 0; i < timers.length; i++) {
			if (timers[i] > Constants.waves[nextWave - 1][3 * i + 2] * (long) 1000000) {
//				System.out.println(timers[i] + "," + Constants.waves[nextWave - 1][3 * i + 2] * (long) 1000000);
				timers[i] %= (long) Constants.waves[nextWave - 1][3 * i + 2] * 1000000;
				if (i == 0) {
					spawnEnemy(new BasicEnemy(0), (int) (Math.random() * spawnPositions.length));
					toSpawn[0]--;
				}
			}
		}
	}

	public void addTower(Tower a, int x, int y) {
		if (getTower(x, y) != null) {
			return;
		}
		// a.setX(x*TILE_WIDTH);
		// a.setY(y*TILE_HEIGHT);
		add(a);
		grid[x][y] = a;
	}

	public Tower getTower(int x, int y) {
		return grid[x][y];
	}

	public void spawnEnemy(Enemy e, int spawnPosition) {
		e.setX(spawnPositions[spawnPosition][0]);
		e.setY(spawnPositions[spawnPosition][1]);
		add(e);
	}

	public void newWave(int waveNum) {
		if (waveNum > 0) {
			return;
		}
		for (int i = 0; i * 3 < Constants.waves.length; i++) {
			int max = Constants.waves[waveNum][3 * i + 1];
			int min = Constants.waves[waveNum][3 * i];
			toSpawn[i] = (int) (Math.random() * (max - min + 1)) + min;
		}
		nextWave++;
	}
}
