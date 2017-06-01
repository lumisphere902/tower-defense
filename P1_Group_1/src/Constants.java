import javafx.scene.image.Image;

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
	
	public static final EnemyData[] enemyTypes = {
			new EnemyData(0,"basicEnemy.png"),
			new EnemyData(1,"cat2.gif"),
			new EnemyData(2,"arthur.png"),
			new EnemyData(3,"harambe.png"),
			new EnemyData(4,"doggo.png"),
	};
	
	public static final ProjectileData[] projTypes = {
			new ProjectileData(0, "basicProjectile.png"),
			new ProjectileData(1, "aoeProjectile.png"),
			new ProjectileData(2, "sunProjectile.png"),
			new ProjectileData(3, "samosa.png"),
			new ProjectileData(4, "torch.png"),
			new ProjectileData(5, "brain.png"),
			new ProjectileData(6, "salt.png")
		};
}
class TowerData {
	private int cost;
	private Image image;
	private Image bwimage;
	private Image worldImage;
	private Image thumbnail;
	private int type;
	
	public TowerData(int type, int cost, String image) {
		super();
		this.cost = cost;
		this.image = new Image("file:" + image, 50, 50, false, false);
		this.thumbnail = (new Image("file:" + image, 25, 25, false, false));
		this.bwimage = new Image("file:BW" + image, 50, 50, false, false);
		this.worldImage = new Image("file:" + image, World.TILE_WIDTH, World.TILE_HEIGHT, false, false);
		this.type = type;
	}
	public Image getWorldImage() {
		return worldImage;
	}
	public Image getBwimage() {
		return bwimage;
	}
	public int getCost() {
		return cost;
	}
	public Image getImage() {
		return image;
	}
	public int getType() {
		return type;
	}
	public Image getThumbnail() {
		return thumbnail;
	}
}
class EnemyData {
	private Image deathImage;
	private Image worldImage;
	private int type;
	
	public EnemyData(int type, String image) {
		this.deathImage = new Image("file:death" + image, 50, 50, false, false);
		this.worldImage = new Image("file:" + image, 50,50,false,false);
		this.type = type;
	}
	public Image getDeathImage() {
		return deathImage;
	}
	public Image getWorldImage() {
		return worldImage;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
class ProjectileData {
	private Image image;
	private int type;
	
	public ProjectileData(int type, String image) {
		this.image = new Image("file:" + image, 50, 50, false, false);
		this.type = type;
	}
	public Image getImage() {
		return image;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}