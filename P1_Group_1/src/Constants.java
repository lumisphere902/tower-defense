import javafx.scene.image.Image;

public final class Constants {
	public static final int[][] waves = {
//	 minBasic	maxBasic	timePerBasic
	{3,			5,			3000
	}
};
	public static final TowerData[] towerTypes = {
//		
	new TowerData(50,"basicTower.png")
	};
}
class TowerData {
	private int cost;
	private Image image;
	public TowerData(int cost, String image) {
		super();
		this.cost = cost;
		this.image = new Image("file:" + image, 50, 50, false, false);
		System.out.println(this.image.getWidth());
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
}