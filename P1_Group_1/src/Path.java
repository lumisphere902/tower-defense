
public abstract class Path {
	Enemy e;
	
	public Path(Enemy enemy) {e = enemy;}

	public abstract void nextMove();
	
}
