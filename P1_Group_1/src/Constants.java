import javafx.scene.image.Image;

public final class Constants {
	public static final int[][] waves = {
//	 minBasic	maxBasic	timePerBasic	minAngry	maxAngry	timePerAngry	minRegen	maxRegen	timePerRegen	minHarambe	maxHarambe	timePerHarambe	minDoggo	maxDoggo	timePerDoggo	
	{7,			20,			1105,			0,			0,			6416,			0,			0,			3460,			0,			0,			3438,			0,			0,			10847},
	{5,			18,			1139,			0,			0,			5051,			2,			3,			3266,			0,			0,			3354,			0,			0,			10186},
	{8,			20,			1097,			0,			0,			5327,			3,			6,			3697,			0,			1,			3455,			0,			0,			11691},
	{5,			17,			1399,			0,			1,			6114,			2,			6,			2050,			1,			2,			4047,			0,			0,			11178},
	{8,			19,			1501,			0,			1,			4770,			5,			9,			1805,			3,			4,			3288,			7,			9,			10394},
	{15,		15,			1765,			0,			2,			6058,			5,			7,			2176,			2,			5,			3341,			5,			7,			10657},
	{16,		19,			553,			2,			5,			6596,			9,			1,			2164,			2,			3,			4316,			7,			8,			9879},
	{15,		15,			294,			4,			7,			5740,			7,			0,			3423,			4,			7,			3791,			6,			6,			11337},
	{18,		20,			423,			2,			4,			5738,			6,			6,			3524,			3,			3,			2873,			6,			6,			11210},
	{29,		33,			1758,			1,			1,			6168,			5,			8,			3267,			3,			6,			4645,			8,			9,			10158},
	{26,		29,			773,			4,			4,			4798,			15,			17,			2813,			1,			2,			3536,			7,			7,			9914},
	{29,		29,			1133,			1,			3,			6505,			17,			19,			2040,			14,			14,			4455,			5,			7,			9903},
	{28,		31,			918,			11,			14,			6505,			16,			19,			3642,			10,			14,			3133,			8,			11,			9829},
	{28,		30,			1627,			12,			15,			6586,			18,			19,			1713,			11,			15,			3829,			8,			8,			10614},
	{25,		25,			447,			10,			12,			5468,			16,			18,			3199,			11,			15,			3087,			5,			5,			10397},


};
	public static final TowerData[] towerTypes = {
		new TowerData(0,	50,	"basicTower.png"),	
		new TowerData(1,	 100,	 "aoeTower.png"),	
		new TowerData(2,	 100,	 "teletubbies.png"),	
		new TowerData(3,	 100,	 "tunak.png"),	
		new TowerData(4,	 200,	 "allThings.png"),	
		new TowerData(5,	 500,	 "brain.png"),	
		new TowerData(6,	 100,	 "saltbae.png")
	};
	
	public static final EnemyData[] enemyTypes = {
			new EnemyData(0,	"basicEnemy.png"),	
			new EnemyData(1,	"cat2.gif"),	
			new EnemyData(2,	"arthur.png"),	
			new EnemyData(3,	"harambe.png"),	
			new EnemyData(4,	"doggo.png"),	
	};
	
	public static final ProjectileData[] projTypes = {
			new ProjectileData(0,	 "basicProjectile.png"),	
			new ProjectileData(1,	 "aoeProjectile.png"),	
			new ProjectileData(2,	 "sunProjectile.png"),	
			new ProjectileData(3,	 "samosa.png"),	
			new ProjectileData(4,	 "torch.png"),	
			new ProjectileData(5,	 "brain.png"),	
			new ProjectileData(6,	 "salt.png")
		};
}
class TowerData {
	private int cost;
	private Image image;
	private Image bwimage;
	private Image worldImage;
	private Image thumbnail;
	private int type;
	
	public TowerData(int type,	 int cost,	 String image) {
		super();
		this.cost = cost;
		this.image = new Image("file:" + image,	 50,	 50,	 false,	 false);
		this.thumbnail = (new Image("file:" + image,	 25,	 25,	 false,	 false));
		this.bwimage = new Image("file:BW" + image,	 50,	 50,	 false,	 false);
		this.worldImage = new Image("file:" + image,	 World.TILE_WIDTH,	 World.TILE_HEIGHT,	 false,	 false);
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
//	private Image deathImage;
	private Image worldImage;
	private int type;

	public EnemyData(int type, String image) {
//		this.deathImage = new Image("file:death" + image, 50, 50, false, false);
		this.worldImage = new Image("file:" + image, 50, 50, false, false);
		this.type = type;
	}

//	public Image getDeathImage() {
//		return deathImage;
//	}

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