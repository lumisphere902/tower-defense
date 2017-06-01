import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TextNotification extends Label implements Act {

	private long start;

	public TextNotification(String text) {
		super(text);
		this.start = 0;
		FadeTransition ft = new FadeTransition(Duration.millis(3000), this);
		ft.setFromValue(1.0);
		ft.setToValue(0);
		ft.setCycleCount(4);
		ft.setAutoReverse(false);
		ft.play();
	}

	public void act(long diff) {
		start += diff;
		if (start / 1000000 >= 2700) {
			((GameWorld) getParent()).getChildren().remove(this);
		}
		toFront();
	}

}
