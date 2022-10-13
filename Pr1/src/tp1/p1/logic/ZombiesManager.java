package tp1.p1.logic;
//ZombieManager tiene que ser conocido por Game
//Tiene que conocer a ZombieList
import java.util.Random;

import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.Zombie;
import tp1.p1.logic.gameobjects.ZombieList;
/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {
	//clase con el main
	private Game game;

	private Level level;

	private Random rand;

	private int remainingZombies;

	private ZombieList zombies;
	private int number; //Numero de zombies que hay
	public ZombiesManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombies = new ZombieList(level.getNumberOfZombies()); //Crea una zombilist de longitud remaining zombis
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie()
				&& isPositionEmpty(Game.NUM_COLS, row); //Trabajar sobre el isPositionEmpty que falta

		if(canAdd) {
			// TODO fill your code
			Zombie z_nuevo= new Zombie();
			this.zombies.insertar(z_nuevo);
			this.number++;
			this.zombies.cambiarposx_ultimo(row);
			this.zombies.cambiarposy_ultimo(9);//revisar
			//this.zombies[this.number].setZombie_y= Game.NUM_COLS+1; No sé como meterlo porque en teoría zombieManager no tiene que importar a Game sino al revés
			//ahora falta actualizar la posicion donde lo meto que falta ver donde lo guardo
		}
		return canAdd;
	}
	
	// TODO fill your code
	private int getRemainingZombies() {
		int num = (level.getNumberOfZombies()-this.number);
		return num;
	}
	
	public boolean hayalgunzombie(int x, int y) {
		int contador= this.zombies.getcontador();
		for(int i=0; i<contador; i++) {
			if(this.zombies.getposx(i)==x&&this.zombies.getposy(i)==y) {
				return true;
			}
		}
		return false;
	}
	public int endurance(int x, int y) {
		int endurance=0;
		int contador=this.zombies.getcontador();
		for (int i=0; i<contador; i++) {
			if (hayalgunzombie(x,y)) {
				endurance= this.zombies.endurance(i);
				return endurance;
			}
		}
		return endurance;
	}
	
	public void atacar(int x, int y) {
		int contador= this.zombies.getcontador();
		for(int i=0; i<contador; i++) {
			if(this.zombies.sacar_zombie(i).getZombie_x()==x&&this.zombies.sacar_zombie(i).getZombie_y()==y) {
				this.zombies.sacar_zombie(i).disparado_Peashooter();
			}
		}
	}

	private static boolean isPositionEmpty(int col, int fila) {
		return true; // hay que hacer la función
	}

	//Hacer que avancen los zombies, para ello igual meter un atributo de los ciclos que llevan creados cada zombie para saber si tienen que avanzar o no
	
}