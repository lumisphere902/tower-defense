public final class Constants {
	public static final int[][] waves = {
//	 minBasic	maxBasic	timePerBasic	minAngry	maxAngry	timePerAngry	minRegen	maxRegen	timePerRegen
	{5,			5,			3000,			3,			4,			10300,				0,			0,			0},
	{20,		20,			500,			1,			1,			10000,			1,			1,			5000}
};
	public static final TowerData[] towerTypes = {
		new TowerData(0,50,"basicTower.png"),
		new TowerData(1, 100, "aoeTower.png"),
		new TowerData(2, 50, "teletubbies.png"),
		new TowerData(3,  50, "tunak.png")
	};
	public static final TowerData[] enemyTypes = {
			new TowerData(0,0,"basicEnemy.png"),
			new TowerData(0,0,"cat.png"),
			new TowerData(0,0,"arthur.png")
	};
}
class TowerData {
	private int cost;
	private String image;
	private int type;
	
	public TowerData(int type, int cost, String image) {
		super();
		this.cost = cost;
		this.image = image;
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