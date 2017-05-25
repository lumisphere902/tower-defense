public final class Constants {
	public static final int[][] waves = {
//	 minBasic	maxBasic	timePerBasic
	{3,			5,			3000},
	{100,		105,			500}
};
	public static final TowerData[] towerTypes = {
		new TowerData(0,50,"basicTower.png"),
		new TowerData(1, 100, "aoeTower.png")
	};
	public static final TowerData[] enemyTypes = {
			new TowerData(0,0,"basicEnemy.png")
	};
}
class TowerData {
	private int cost;
	private String image;
	private int type;
	
	public TowerData(int type, int cost, String image) {
		super();
		this.cost = cost;
		this.image = image;//MAY NEED TO BE 50*50?
		this.type = type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}