
public class RagDoll extends Actor {
	private long start;

	public RagDoll() {
		super();
		this.start = 0;
	}

	@Override
	public void act(long diff) {
		start+=diff;
		if (start/1000000 >= 3000) {
			getWorld().remove(this);
		}
	}

}
