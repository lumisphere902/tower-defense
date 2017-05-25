import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class RagDoll extends Actor {
	private long start;

	public RagDoll() {
		super();
		this.start = 0;
		FadeTransition ft = new FadeTransition(Duration.millis(2500), this);
		ft.setFromValue(1.0);
		ft.setToValue(0);
		ft.setCycleCount(4);
		ft.setAutoReverse(false);

		ft.play();
	}

	@Override
	public void act(long diff) {
		start += diff;
		if (start / 1000000 >= 3000) {
			getWorld().remove(this);
		}
	}

}
