package tp1.p2.logic;

import java.util.Random;

import tp1.p2.control.Level;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;


import tp1.p2.control.exceptions.GameException;

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
		return rand.nextInt(ZombieFactory.getAvailableZombies().size());
	}

	public void update ()throws GameException {
		try {
			addZombie();
		}catch(GameException e) { //Todo esto no creo q sean gameexception sino que igual son commandexecute exception o q se yo
			throw e;
		}
		
	}

	public boolean addZombie() throws GameException {
		int row = randomZombieRow();
		try {
			return addZombie(row);
		}catch(GameException e) {
			throw e;
		}
		
	}

	public boolean addZombie (int row) throws GameException{               
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie() && !game.isFullyOcuppied(GameWorld.NUM_COLS, row);
		int zombieType = randomZombieType();
		if (canAdd) {
			Zombie z = ZombieFactory.AVAILABLE_ZOMBIES.get(zombieType);
			Zombie zombie = z.create(game, GameWorld.NUM_COLS, row);
			try {
				game.checkValidZombiePosition(zombieType, row);
				game.addItem(zombie);
				remainingZombies --;
				return canAdd;
			}catch (GameException e) {
				throw e;
			}
			
		}
		return canAdd;
	}

	protected int getRemainingZombies() {
		return this.remainingZombies;
	}
	
	private int getZombiesAlived() {
		return this.zombiesAlived;
	}
	
	protected boolean playerWon() {
		if(this.getZombiesAlived()==0 && this.getRemainingZombies()==0) {
			return true;
		}
		return false;
	}

	protected void decreaseZombiesAlived() {
		this.zombiesAlived--;
	}
	
	protected void addZombiesAlived() {
		this.zombiesAlived += 1;	
	}

	protected boolean zombiesDead() {
		return zombiesAlived == 0;
	}
}