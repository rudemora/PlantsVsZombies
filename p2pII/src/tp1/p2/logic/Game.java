package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List; // es necesario?
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult; // por qué aquí?
import tp1.p2.control.Level;
import tp1.p2.logic.actions.ExplosionAction; //importado por nosotros, se hace realmente así?
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class Game implements GameStatus, GameWorld {

	private static final int INITIAL_SUNCOINS = 50; 
	private static final int INITIAL_CYCLE = 0;
	private long seed;

	private Level level;
	
	private int cycle;

	private GameObjectContainer container;

	private Deque<GameAction> actions;

	private static boolean playerQuits;
	private static boolean endGame;
	
	private Random rand;
	
	private ZombiesManager zombiesManager;
	
	private SunsManager sunsManager;
	

	private int sunCoins;
	
	public Game(long seed, Level level) {
		this.reset(seed, level);
	}

	
	/**
	 * Resets the game with the provided level and seed.
	 * 
	 * @param level {@link Level} Used to initialize the game.
	 * @param seed Random seed Used to initialize the game.
	 */
	public void reset( long seed ,Level level) {
		this.seed = seed;
		this.level = level;
		container = new GameObjectContainer(); 
		cycle = INITIAL_CYCLE;
		playerQuits = false;
		this.actions = new ArrayDeque<>();
		this.rand = new Random(this.seed);
		this.zombiesManager= new ZombiesManager(this,level,rand);
		sunCoins = INITIAL_SUNCOINS;
		this.sunsManager = new SunsManager(this, rand);
		this.endGame = false;
		System.out.println(String.format(Messages.CONFIGURED_LEVEL, level.name()));
		System.out.println(String.format(Messages.CONFIGURED_SEED, seed));
	}

	
	public Level getLevel() {
		return this.level;
	}
	
	public long getSeed() {
		return this.seed;
	}
	
	
	
	/**
	 * Executes the game actions and update the game objects in the board.
	 * 
	 */
	
	public void update() {

		// 1. Execute pending actions
		executePendingActions();
		
		// 2. Execute game Actions
		zombiesManager.update();
		sunsManager.update();
		//container.removeDead();
		// 3. Game object updates
		container.update();
		
		// 4. & 5. Remove dead and execute pending actions
		boolean deadRemoved = true;
		while (deadRemoved || areTherePendingActions()) {
			// 4. Remove dead
			deadRemoved = this.container.removeDead();
			// 5. execute pending actions
			executePendingActions();
		}

		this.cycle++;

		// 6. Notify commands that a new cycle started
		Command.newCycle();

	}

	private void executePendingActions() {
		while (!this.actions.isEmpty()) {
			GameAction action = this.actions.removeLast();
			action.execute(this);
		}
	}

	public void pushAction(GameAction gameAction) {
	    this.actions.addLast(gameAction);
	}
	
	
	private boolean areTherePendingActions() {
		return this.actions.size() > 0;
	}
	
	/**
	 * Checks if a cell is fully occupied, that is, the position can be shared between an NPC (Plant, Zombie) and Suns .
	 * 
	 * @param col Column of the cell
	 * @param row Row of the cell
	 * 
	 * @return <code>true</code> if the cell is fully occupied, <code>false</code>
	 *         otherwise.
	 */
	public boolean isFullyOcuppied(int col, int row) {
		return this.container.isFullyOccupied(col, row);
	}
	
	public boolean execute (Command command) {
    	return command.execute(this).draw();
    }

	public boolean isFinished() {
		if(this.zombiesManager.playerWon()) {
			endGame=true;
		}
		return endGame;
		
	}
	
	public boolean playerWon() {
		if(this.zombiesManager.playerWon()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean isPlayerQuits() {
		return playerQuits;
	}

	public boolean addItem(GameObject gameObject) { 
		
		int columna = gameObject.getCol();
		int fila = gameObject.getRow();
		if (columna >= 0 && columna < Game.NUM_COLS && fila >= 0 && fila < Game.NUM_ROWS) {
			if(!this.isFullyOcuppied(columna,fila)) {
				this.addGameItem(gameObject);
	    		return true;
	    	}
			else {
	        	return false;
	    	}
		}
		else {
			System.out.println(error(Messages.INVALID_POSITION));
			return false;
		}
		
	}
	
	
	public int getCaughtSuns() {
		return sunsManager.getCaughtSuns();
	}
	
	
	public int getCycle() {
		return cycle;
	}

	
	public int getSuncoins() {
		return sunCoins;
	}

	
	public int getRemainingZombies() {
		return  this.zombiesManager.getRemainingZombies();
	}

	
	public String positionToString(int col, int row) {
	StringBuilder str = new StringBuilder();
		if(!container.isPositionEmpty(col, row)) {
			str.append(container.positionToString(col,row));
		}
		return str.toString();
	}
	
	public GameItem getGameItemInPosition(int col, int row) {
    	return container.getGameItemInPosition(col, row);
    }
	
	public boolean tryToCatchObject(int col, int row) {
		return container.tryToCatchObject(col, row);
		
	}
	
	
	public int getGeneratedSuns() {
		return this.sunsManager.getGeneratedSuns();
	}

	
	public void playerQuits() {
		playerQuits = true;
		
	}
	
	public boolean isPositionEmpty(int x, int y) {
    	return container.isPositionEmpty(x, y);
    }
	
	public boolean consumeCoins(GameObject object, int coste) {
    	if(coste <= this.sunCoins) {
        	this.sunCoins = this.sunCoins-coste;
        	return true;
    	}
    	return false;
    }
	
	
	public void addGameItem(GameObject object) {
    	container.addObject(object);
    }
	
	public void addSuncoins(int coins) {
	    	sunCoins = sunCoins + coins;
	 }
	 
	 public void addSun() {
		 sunsManager.addSun();
	 }
	 
	 /*
	 private boolean zombiesGana() {
	    	return container.zombiesGana();
	 }*/
	
	 public void explode(int col, int row, int damage, boolean affectsZombies) {
		 for(int i = col-1; i <= col + 1; i++) {
			 for(int j = row-1; j<= row +1;j=j+1) {
					 GameItem item = this.getGameItemInPosition(i, j);
					 if (item != null) {
						 if (affectsZombies) {
							 item.receivePlantAttack(damage);
						 }
						 else {
							 item.receiveZombieAttack(damage);
						 }
					 }
			 }
		 }	    
	 }


	
	public void addZombiesAlived() {
		zombiesManager.addZombiesAlived();
	}

	public void removeDead() {
		this.container.removeDead();
	}
	
	public void decreaseZombiesAlived() {
		zombiesManager.decreaseZombiesAlived();
	}
	
	
	
	public void addCaughtSuns() {
		this.sunsManager.addCaughtSuns();
	}
	
	public boolean zombiesGana() {
		endGame = true;
		return true;
	}
}