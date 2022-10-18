package tp1.p1.logic;
//Tiene que conocer a ZombieManager
import java.util.Random;

import tp1.p1.control.Level;

import tp1.p1.logic.gameobjects.*;
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
		this.suncoins=50;
		this.countCycles = 0;
		this.rand= new Random(this.seed);
		this.zombies= new ZombiesManager(this,level,rand);
		int tamano= NUM_COLS*NUM_ROWS;
		this.Peashooters= new PeashooterList (tamano,this);
		this.Sunflowers= new SunflowerList (tamano,this);
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
	public void pagar(int x) {
		this.suncoins=this.suncoins-x;
	}
	
	
	//:)
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
	
	public PeashooterList crearPeashooterList() {
		int tamano=NUM_COLS*NUM_ROWS;
		PeashooterList P_list= new PeashooterList(tamano,this);
		return P_list;
		
	}
	public SunflowerList crearSunflowerList() {
		int tamano=NUM_COLS*NUM_ROWS;
		SunflowerList S_list= new SunflowerList(tamano,this);
		return S_list;
		
	}
	public ZombieList crearZombieList() {
		int tamano=8;//Tiene que ser el number zombies del level que de momento no sabemos
		ZombieList Z_list= new ZombieList(tamano);
		return Z_list;
		
	}
	public void add_P(int x, int y) {
		this.Peashooters.add_Peashooter(x,y);
		this.suncoins=this.suncoins-50;
	}
	public void add_S(int x, int y) {
		this.Sunflowers.add_Sunflower(x,y);
		this.suncoins=this.suncoins-20;
		
	}

	
	
	
	public boolean isPositionEmpty(int x, int y) {
		if (x>= 0 && x < NUM_COLS && y>= 0 && y < NUM_ROWS) {
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
		else {
			return false;
		}
		
	}
	
	public void zombie_atacado (int x, int y) {
		this.zombies.zombie_atacado(x, y);
	}
	
	public void p_atacado(int x, int y, int dano) {
		this.Peashooters.p_atacado(x, y, dano);
	}
	public void s_atacado(int x, int y, int dano) {
		this.Sunflowers.s_atacado(x, y, dano);
	}
	public boolean quiengana() { //Una vez acabada la partida, devuelve true si ganan los zombies
		if(this.zombies.zombie_gana()) {
			return true;
		}
		return false;
	}
	public boolean update() {//Privado no tiene que ser, no?  //ver la razón de que sea boolean o no
		this.Sunflowers.update();
		this.Peashooters.update();
			return this.zombies.update();		
	}
	
	
	public long getSeed () {
		return this.seed;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	
	/*public String positionToString(int col, int row) {
		return  ("col"); // hacer la función
	}*/
	
	//métodos addPeashooter, addSunflower (col, fila), método reset(inicializa una partida, mirar si es el mismo código que cuando 
	//creamos la partida)
	//creamos metodo update, ejecuta game action y update, tercer y cuarto paso del run
	//podemos poner un método update dentro de sunflower y desde ahí lo hacemos, habrá que recorrer la lista desde ahí, también desde PeashooterList
	//el método update del SunflowerList, hacemos un for para ver cada sunflower, hacemos un update: sf.update, ve si está vivo, sf.get() y sf.setciclos()

}
