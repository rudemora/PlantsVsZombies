package tp1.p2.logic;

import java.util.Random;

import tp1.p2.control.Level;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;

/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {

	private GameWorld game;

	private Level level;

	private Random rand;

	private int remainingZombies;
	
	private int zombiesAlived;
	
	private GameObjectContainer lista;

	public ZombiesManager(GameWorld game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombiesAlived = 0;
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
		return rand.nextInt(GameWorld.NUM_ROWS);
	}

	private int randomZombieType() {
		return 0;// rand.nextInt(ZombieFactory.getAvailableZombies().size()); preguntar en lab
	}

	public void update() {
		addZombie();
	}

	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}
	private int getRemainingZombies() {
		return this.remainingZombies;
	}
	
	private boolean isPositionEmpty(int x, int y) {
		return game.isPositionEmpty(x, y);
	}

	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie() && isPositionEmpty(GameWorld.NUM_COLS, row);
		int zombieType = randomZombieType();
		if (canAdd) {
			Zombie zombie = ZombieFactory.AVAILABLE_ZOMBIES.get(zombieType);
			Zombie z = zombie.create(game, row);
			game.addObject(z);
			game.restarZombies();
			// TODO add your code here
		}
		return canAdd;
	}

	// TODO add your code here

}