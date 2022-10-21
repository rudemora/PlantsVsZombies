package tp1.p1.logic;
//Tiene que conocer a ZombieManager
import java.util.Random;

import tp1.p1.control.Level;

import tp1.p1.logic.gameobjects.*;
import tp1.p1.view.GamePrinter;
import tp1.p1.view.Messages;
import tp1.p1.logic.ZombiesManager;

public class Game {
	
	public static int NUM_COLS = 8;
	public static int NUM_ROWS = 4;
	
	private long seed;
	private Level level;
	private ZombiesManager zombies;
	
	private PeashooterList Peashooters;
	private SunflowerList Sunflowers;
	private int suncoins;
	private Random rand;
	private int countCycles;
	public Game(long s, Level l) {
		this.seed = s;
		this.level =l;
		this.reset();
	}
	
	public int getCountCycles() {
		return countCycles;
	}
	
	public void addCycles() {
		this.countCycles += 1;
	}
	
	public int getSuncoins() {
		return this.suncoins;
	}
	
	public int getRemainingZombies() {
		return zombies.getRemainingZombies();
	}
	public void setSuncoins(int suma) {
		this.suncoins=suma;
	}
	
	public void reset() {
		this.suncoins=50;
		this.countCycles = 0;
		this.rand= new Random(this.seed);
		this.zombies= new ZombiesManager(this,level,rand);
		int tamano= NUM_COLS*NUM_ROWS;
		this.Peashooters= new PeashooterList (tamano,this);
		this.Sunflowers= new SunflowerList (tamano,this);
	}
	
	public String positionToString(int col, int row) {
		String escribe= "";
		if(zombies.hayalgunzombie(col, row)) {
			int endurance = zombies.endurance(col, row);
			return String.format(Messages.ZOMBIE_ICON, endurance);
		}
		else if(Peashooters.hayalgunPeashooter(col, row)) {
			int endurance = Peashooters.endurance(col, row);
			return String.format(Messages.PEASHOOTER_ICON, endurance);

		}
		else if (Sunflowers.hayalgunSunflower(col, row)) {
			int endurance = Sunflowers.endurance(col, row);
			return String.format(Messages.SUNFLOWER_ICON, endurance);
		}
		return escribe;
	}
	
	public void add_Peashooter(int x, int y) {
		int coste = this.Peashooters.add_Peashooter(x,y);
		this.suncoins=this.suncoins-coste;
	}
	public void add_Sunflower(int x, int y) {
		int coste = this.Sunflowers.add_Sunflower(x,y);
		this.suncoins=this.suncoins-coste;
	}

	
	public boolean isPositionEmpty(int x, int y) {
		if(this.Peashooters.hayalgunPeashooter(x, y)) {
			return false;
		}
		if(this.Sunflowers.hayalgunSunflower(x, y)) {
			return false;
		}
		if (this.zombies.hayalgunzombie(x, y)) {
			return false;
		}
		return true;		
	}
	
	public void zombie_atacado (int x, int y, int damage) {
		int cols = NUM_COLS;
		this.zombies.zombie_atacado(x, y, damage, cols);
	}
	
	public void peashooter_atacado(int x, int y, int dano) {
		this.Peashooters.peashooter_atacado(x, y, dano);
	}
	
	public void sunflower_atacado(int x, int y, int dano) {
		this.Sunflowers.sunflower_atacado(x, y, dano);
	}
	
	public boolean quiengana() { 
		if(this.zombies.zombie_gana()) {
			return true;
		}
		return false;
	}
	public boolean update() {  
		this.Sunflowers.update();
		this.Peashooters.update();
			return this.zombies.update();		
	}
	
	public void atacar(int x, int y, int dano) {
		this.peashooter_atacado(x, y, dano); 
		this.sunflower_atacado(x, y, dano);
	}
	

	
}
