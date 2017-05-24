/*import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class HealthBar{
	Rectangle left; Rectangle used;
	BasicEnemy e;
	
	public HealthBar(BasicEnemy enemy) {
		e = enemy;
		left = new Rectangle(e.getX(), e.getY(),  e.getStartingHealth(), 2);
		left.setFill(Color.GREEN);
		used = new Rectangle(e.getX(), e.getY(), 0, 2);
		used.setFill(Color.RED);
		
	}
	
	public void act(){
		left.resize(2,e.getHealth());
		used.resize(2,e.getStartingHealth() - e.getHealth());
		u
	}
}
*/