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
	private int number; //Numero de zombies que han salido
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
				&& game.isPositionEmpty(Game.NUM_COLS, row); //Trabajar sobre el isPositionEmpty que falta

		if(canAdd) {
			// TODO fill your code
			Zombie z_nuevo= new Zombie();
			z_nuevo.setZombie_y(row);
			z_nuevo.setZombie_x(game.NUM_COLS);
			this.zombies.insertar(z_nuevo);
			
			this.remainingZombies--;
			
			
			
			//ahora falta actualizar la posicion donde lo meto que falta ver donde lo guardo
		}
		return canAdd;
	}
	
	// TODO fill your code
	private int getRemainingZombies() {
		return this.remainingZombies;
	}
	
	public boolean hayalgunzombie(int x, int y) {
		return this.zombies.hayalgunzombie(x, y);
	}

	
	public void zombie_atacado(int x, int y) {
		this.zombies.zombie_atacado(x, y, this.game.NUM_COLS);
		
	}
	public void matar() {
		this.zombies.matar_muertos();;
	}
	public void actualizar_ciclos() {
		this.zombies.actualizar_ciclos();
	}
	public int endurance(int x, int y) {
		return this.zombies.endurance(x,y);
	}
	public boolean zombie_gana() {
		return this.zombies.zombie_gana();
	}
	
	public boolean quedan_zombies() {
		return this.zombies.quedan_zombies();
	}

	public boolean update() {
		int contador=this.zombies.getcontador();
		int posx;
		int posy;
		for(int i=0; i<contador;i++) {
			posx=this.zombies.getposx(i);
			posy=this.zombies.getposy(i);
			if(this.game.isPositionEmpty(posx-1, posy)) {//Compruebo si el zombie tiene que avanzar o hacer daño
				this.zombies.getzombie(i).avance();
			}
			else {
				this.game.p_atacado(posx -1, posy, 1);//Hace siempre 1 de dano en esta practica
				this.game.s_atacado(posx -1, posy, 1);
			}
			
		}
		this.actualizar_ciclos();
		this.matar();
		if(!addZombie()&&this.remainingZombies==0) {
			if(!quedan_zombies()) {
				return false;
			}
		}
		else if(zombie_gana()) {
			return false;
		}
		return true;
	}
	

	//Hacer que avancen los zombies, para ello igual meter un atributo de los ciclos que llevan creados cada zombie para saber si tienen que avanzar o no
	
}