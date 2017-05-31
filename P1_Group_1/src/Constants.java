public final class Constants {
	public static final int[][] waves = {
//	 minBasic	maxBasic	timePerBasic	minAngry	maxAngry	timePerAngry	minRegen	maxRegen	timePerRegen	minHarambe	maxHarambe	timePerHarambe	minDoggo	maxDoggo	timePerDoggo	
	{5,			7,			3000,			2,			2,			10300,			3,			3,			1500, 			5,			5,			5000,			5,			5,			10000		},
	{15,		25,			500,			1,			1,			10000,			1,			1,			5000, 			10, 		10, 		3000, 			5,			15, 		20000}
};
	public static final TowerData[] towerTypes = {
		new TowerData(0,50,"basicTower.png"),
		new TowerData(1, 100, "aoeTower.png"),
		new TowerData(2, 50, "teletubbies.png"),
		new TowerData(3,  50, "tunak.png"),
		new TowerData(4, 200, "allThings.png"),
		new TowerData(5, 500, "brain.png"),
		new TowerData(6, 50, "saltbae.png")
	};
	
	public static final TowerData[] enemyTypes = {
			new TowerData(0,0,"basicEnemy.png"),
			new TowerData(1,0,"cat2.gif"),
			new TowerData(2,0,"arthur.png"),
			new TowerData(3,0,"harambe.png"),
			new TowerData(4,0,"doggo.png"),
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