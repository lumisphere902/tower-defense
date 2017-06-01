
import java.io.File;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

public class GameWorld extends World {

	private Tower[][] grid;
	private static final int[][] spawnPositions = { { 0, 0 } };
	private int nextWave = 0;
	private int[] toSpawn = new int[Constants.enemyTypes.length];
	private long[] timers = new long[Constants.enemyTypes.length];
	private BorderPane hud;
	private double money;
	private int[] basePos = { GRID_WIDTH * TILE_WIDTH - 150, GRID_HEIGHT * TILE_HEIGHT - 150 };
	private Base base;
	private boolean gameOver = false;
	private boolean ending = false;
	boolean[][] buildable;
	private int currTower = -1;
	private boolean canBuild = false;
	private boolean waiting = false;
	private Image towerImg;
	private Image xImg = new Image("file:x.png", 50, 50, false, false);
	private AudioClip deathSound;
	private Image grass = new Image("file:grass.png", TILE_WIDTH, TILE_HEIGHT, false, false);
	private Image rainbow = new Image("file:rainbowSquare.jpg", TILE_WIDTH, TILE_HEIGHT, false, false);
	//private boolean waveOn;

	public GameWorld() throws Exception {
		super();
		deathSound = new AudioClip(new File("coins.wav").toURI().toURL().toString());
		buildable = new boolean[GRID_WIDTH][GRID_HEIGHT];
		for (int x = 0; x < GRID_WIDTH; x++) {
			for (int y = 0; y < GRID_HEIGHT; y++) {
				if (y == 4 || y == 5 || y == 8 || y == 9 || y == 12 || y == 13) {
					buildable[x][y] = false;
				} // horizontal paths
				else if ((x == 0 || x == 1) && (y < 6 || (y >= 8 && y < 14))) {
					buildable[x][y] = false;
				} // vertical left side
				else if ((x == 18 || x == 19) && (y >= 4 && y < 10)) {
					buildable[x][y] = false;
				} // vertical right side
				else if (y >= 12 && x >= 14) {
					buildable[x][y] = false;
				} // tower
				else {
					buildable[x][y] = true;
				}
			}
		}
		
		/*
		  for (boolean[] r : buildable) { for (boolean b : r) {
		  System.out.print(b + (b ? "  " : " ")); } System.out.println(); }
		*/
		
		for (int j = 0; j < GRID_HEIGHT; j++) {
			for (int i = 0; i < GRID_WIDTH; i++) {
				Image img;
				if (buildable[i][j]) {
					img = grass;

				} else {
					img = rainbow;
				}
				Tile imgView = new Tile(img);
				imgView.setX(i * TILE_WIDTH);
				imgView.setY(j * TILE_HEIGHT);
				imgView.setOnMouseEntered(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (currTower < 0) {
							getScene().setCursor(Cursor.DEFAULT);
							return;
						}
						int gridX = (int) (event.getX() / TILE_WIDTH);
						int gridY = (int) (event.getY() / TILE_HEIGHT);
						if (getTower(gridX, gridY) == null && buildable[gridX][gridY]) {
							getScene().setCursor(new ImageCursor(towerImg, 25, 25));
							canBuild = true;
						} else {
							getScene().setCursor(new ImageCursor(xImg, 25, 25));
							canBuild = false;
						}
					}
				});
				getChildren().add(imgView);
			}
		}
		setOnMouseClicked(event -> {
			if (currTower < 0 || !canBuild || money < Constants.towerTypes[currTower].getCost()) {
				return;
			}
			int gridX = (int) (event.getX() / TILE_WIDTH);
			int gridY = (int) (event.getY() / TILE_HEIGHT);
			money -= Constants.towerTypes[currTower].getCost();
			Tower tower;
			// THIS NEEDS TO BE CHANGED EACH TIME YOU ADD A NEW TOWER
			switch(currTower){
			case 1: tower = new AoeTower(gridX, gridY);break;
			case 2: tower = new TeleTower(gridX, gridY);break;
			case 3: tower = new TunakTower(gridX, gridY);break;
			case 4: tower = new AllTheThingsTower(gridX, gridY);break;
			case 5: tower = new BrainTower(gridX, gridY);break;
			case 6: tower = new SaltBaeTower(gridX, gridY);break;
			default: tower = new BasicTower(gridX, gridY);break;
			}
			addTower(tower, gridX, gridY);
			currTower = -1;
			getScene().setCursor(Cursor.DEFAULT);
		});
		grid = new Tower[GRID_WIDTH][GRID_HEIGHT];
		money = 1000;
		newWave(nextWave);
		base = new Base();
		base.setX(basePos[0]);
		base.setY(basePos[1]);
		add(base);
	}

	public boolean[][] getBuildable() {
		return buildable;
	}

	@Override
	public void act(long diff) {
		if (ending) {return;}
		if (gameOver) {
			try {
				new Alert(Alert.AlertType.NONE, "YOU HAVE DIED!").show();
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {System.exit(0);}
				}, 3000);
				stop();
				ending = true;
				return;
			} catch (Exception e) {}
		}
		
		
		boolean toNextWave = true;
		for (int i = 0; i < toSpawn.length; i++) {
			if (toSpawn[i] != 0) {
				toNextWave = false;
			}
		}

		if (toNextWave) {
			System.out.println("WAVE DONE");
		}
		
		money += diff / 1_000_000_000.0;
		((Label) ((VBox) hud.getChildren().get(1)).getChildren().get(0)).setText("$" + (int) money);
		for (int i = 0; i < Constants.towerTypes.length; i++) {
			TowerData td = Constants.towerTypes[i];
			if (money < td.getCost()) {
				((ImageView) ((VBox) ((FlowPane) (hud.getChildren().get(0))).getChildren().get(i)).getChildren().get(0))
						.setImage(td.getBwimage());
			} else {
				((ImageView) ((VBox) ((FlowPane) (hud.getChildren().get(0))).getChildren().get(i)).getChildren().get(0))
						.setImage(td.getImage());
			}
		}
		
		if (toNextWave && !waiting) {
			// System.out.println("WAVE DONE");
			waiting = true;

			newWave(nextWave);
			return;
		}

		for (int i = 0; i < toSpawn.length; i++) {
			timers[i] += diff;
		}

		for (int i = 0; i < timers.length; i++) {// NEED TO ADD CODE HERE FOR
													// NEW ENEMIES BUILT
			if (toSpawn[i] > 0 && timers[i] > Constants.waves[nextWave - 1][3 * i + 2] * (long) 1_000_000) {
				// System.out.println(timers[i] + "," + Constants.waves[nextWave
				// - 1][3 * i + 2] * (long) 1000000);
				timers[i] %= (long) Constants.waves[nextWave - 1][3 * i + 2] * 1000000;
				Enemy e;
				switch(i){
				case 0:e = new BasicEnemy();break;
				case 1:e = new NyanCatEnemy();break;
				case 2:e = new RegenEnemy();break;
				case 3:e = new HarambeEnemy();break;
				case 4:e = new DoggoEnemy();break;
				default:e = new BasicEnemy();break;
				}toSpawn[i<5?i:0]--;
				
				spawnEnemy(e, (int)(Math.random()*spawnPositions.length));
			}
		}

		money += diff / 1_000_000_000.0;
		((Label) ((VBox) hud.getChildren().get(1)).getChildren().get(0)).setText("$" + (int) money);
	}

	public void nextWave(){
		//waveOn = true;
	}
	
	public void addTower(Tower a, int x, int y) {
		if (getTower(x, y) != null) {
			return;
		}
		// a.setX(x*TILE_WIDTH);
		// a.setY(y*TILE_HEIGHT);
		add(a);
		grid[x][y] = a;
	}

	public Tower getTower(int x, int y) {
		return grid[x][y];
	}

	public Base getBase() {
		return base;
	}

	public void spawnEnemy(Enemy e, int spawnPosition) {
		e.setX(spawnPositions[spawnPosition][0]);
		e.setY(spawnPositions[spawnPosition][1]);
		add(e);
	}

	public void newWave(int waveNum) {
		waiting = false;
		if (waveNum > 1) {
			return;
		}
		for (int i = 0; i * 3 < Constants.waves[0].length; i++) {
			int max = Constants.waves[waveNum][3 * i + 1];
			int min = Constants.waves[waveNum][3 * i];
			toSpawn[i] = (int) (Math.random() * (max - min + 1)) + min;
		}
		nextWave++;
		System.out.println(Arrays.toString(toSpawn));
		addNotification("Wave " + (waveNum + 1));
	}
	
	public void addNotification(String text) {
		System.out.println("ADD NOTIFICATION");
		TextNotification tn = new TextNotification(text);
		tn.layoutXProperty().bind(widthProperty().subtract(tn.widthProperty()).divide(2));
		tn.layoutYProperty().bind(heightProperty().subtract(tn.heightProperty()).divide(2));
		tn.setFont(new Font("Arial", 100));
		getChildren().add(tn);
	}

	public void setHud(BorderPane hud2) {
		this.hud = hud2;
	}

	public BorderPane getHud() {
		return hud;
	}

	public void gameOver() {
		gameOver = true;
	}

	public void setCurrTower(int i) {
		currTower = i;
	}

	public double getMoney() {
		return money;
	}

	public void setTowerImg(Image image) {
		towerImg = image;
	}

	public AudioClip getDeathSound() {
		return deathSound;
	}

	public void addMoney(double money) {
		this.money += money;
	}
}
