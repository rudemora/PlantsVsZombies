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

	public ZombiesManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombies = new ZombieList(this.remainingZombies);
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
				&& isPositionEmpty(Game.NUM_COLS, row);

		if(canAdd) {
			// TODO fill your code
		}
		return canAdd;
	}
	
	// TODO fill your code
	private int getRemainingZombies() {
		int num = 0; //me he inventado el número para que devuelva un int y no de error pero hay que hacer la función
		return num;
	}
	
	private static boolean isPositionEmpty(int col, int fila) {
		return true; // hay que hacer la función
	}

	
}