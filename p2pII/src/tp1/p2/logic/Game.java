package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List; 
import java.util.Random;
import tp1.p2.control.exceptions.InvalidPositionException;//Importado por mi obviamente
import tp1.p2.control.exceptions.NotCatchablePositionException;//Importado por mi obviamente
import tp1.p2.control.exceptions.NotEnoughCoinsException;//Importado por mi obviamente
import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;


import tp1.p2.control.exceptions.GameException;

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
	
	public Game(long seed, Level level) throws GameException {
		this.reset(seed, level);
	}

	
	/**
	 * Resets the game with the provided level and seed.
	 * 
	 * @param level {@link Level} Used to initialize the game.
	 * @param seed Random seed Used to initialize the game.
	 */
	public void reset(Level level, long seed) throws GameException {
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
		endGame = false;
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
	
	public void update()  {//throws GameException

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
		
		// 7. Update record
		// TODO your code here

	}

	private void executePendingActions() {
		while (!this.actions.isEmpty()) {
			GameAction action = this.actions.removeLast();
			action.execute(this);
		}
	}

	@Override
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
	@Override
	public boolean isFullyOcuppied(int col, int row) {
		return this.container.isFullyOccupied(col, row);
	}
	
	public boolean execute (Command command) throws GameException {
		return command.execute(this);
		
    }

	
	public boolean isFinished() {
		if(this.zombiesManager.playerWon()) {
			endGame=true;
		}
		return endGame;
		
	}
	
	@Override
	public boolean playerWon() {
		if(this.zombiesManager.playerWon()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean isPlayerQuits() {
		return playerQuits;
	}
	@Override
	public void checkValidPlantPosition(int columna, int fila) throws GameException{
		if(columna >= 0 && columna <Game.NUM_COLS && fila >= 0 && fila < Game.NUM_ROWS) {
			if(!this.isFullyOcuppied(columna,fila)) {
				
			}
			else {
				throw new InvalidPositionException(Messages.INVALID_POSITION.formatted(columna, fila));
			}
		}
		else {
			throw new InvalidPositionException(Messages.INVALID_POSITION.formatted(columna, fila));
		}
	}
	
	@Override
	public void checkValidZombiePosition(int columna, int fila) throws GameException{
		if(columna >= 0 && columna <= Game.NUM_COLS && fila >= 0 && fila < Game.NUM_ROWS) {
			if(!this.isFullyOcuppied(columna,fila)) {
				
			}
			else {
				throw new InvalidPositionException(Messages.INVALID_POSITION.formatted(columna, fila));
			}
		}
		else {
			throw new InvalidPositionException(Messages.INVALID_POSITION.formatted(columna, fila));
		}
	}

	@Override
	public void addItem(GameObject gameObject){ 
		
		int columna = gameObject.getCol();
		int fila = gameObject.getRow();		
		this.addGameItem(gameObject);
			
	}
	
	@Override
	public int getCaughtSuns() {
		return sunsManager.getCaughtSuns();
	}
	
	@Override
	public int getCycle() {
		return cycle;
	}

	@Override
	public int getSuncoins() {
		return sunCoins;
	}

	@Override
	public int getRemainingZombies() {
		return  this.zombiesManager.getRemainingZombies();
	}

	@Override
	public String positionToString(int col, int row) {
	StringBuilder str = new StringBuilder();
		if(!container.isPositionEmpty(col, row)) {
			str.append(container.positionToString(col,row));
		}
		return str.toString();
	}
	@Override
	public List<GameItem> getGameItemInPosition(int col, int row) {
    	return container.getGameItemInPosition(col, row);
    }
	
	@Override
	public void tryToCatchObject(int col, int row) throws GameException  {
		if(container.tryToCatchObject(col, row)) {
			this.removeDead();
		}
		else {
			throw new NotCatchablePositionException("No se que mensaje y seguramente meter tb la posicion y tal en la que falla");
		}
		
	}
	
	@Override
	public int getGeneratedSuns() {
		return this.sunsManager.getGeneratedSuns();
	}

	@Override
	public void playerQuits() {
		playerQuits = true;
		
	}
	
	@Override
	public boolean isPositionEmpty(int x, int y) {
    	return container.isPositionEmpty(x, y);
    }
	
	@Override
	public void tryToBuy(int cost) throws GameException{
		if(cost > this.sunCoins) {
			throw new NotEnoughCoinsException(Messages.NOT_ENOUGH_COINS);
		}
		
	}
	
	@Override
	public void consumeCoins(GameObject object, int coste) {
		this.sunCoins = this.sunCoins-coste;
    }
	
	@Override
	public void addGameItem(GameObject object) {
    	container.addObject(object);
    }
	
	@Override
	public void addSuncoins(int coins) {
	    	sunCoins = sunCoins + coins;
	 }
	 
	@Override
	public void addSun() {
		sunsManager.addSun();
	}
	 
	 @Override
	 public void explode(int col, int row, int damage, boolean affectsZombies) {
		 for(int i = col-1; i <= col + 1; i++) {
			 for(int j = row-1; j<= row +1;j=j+1) {
				 List<GameItem> lista = this.getGameItemInPosition(i, j);
				 if (lista != null) {
						 if (affectsZombies) {
							 for(int k =0;k<lista.size();k=k+1) {
								 lista.get(k).receivePlantAttack(damage);
							 }

						 }
						 else {
							 for(int k =0;k<lista.size();k=k+1) {
								 lista.get(k).receiveZombieAttack(damage);
							 }
						 }
				}
			 }
		 }	    
	 }


	@Override
	public void addZombiesAlived() {
		zombiesManager.addZombiesAlived();
	}
	
	
	private void removeDead() {
		this.container.removeDead();
	}
	
	@Override
	public void decreaseZombiesAlived() {
		zombiesManager.decreaseZombiesAlived();
	}
	
	
	@Override
	public void addCaughtSuns() {
		this.sunsManager.addCaughtSuns();
	}
	
	@Override
	public boolean zombiesGana() {
		endGame = true;
		return true;
	}


	@Override
	public void reset(long seed, Level level) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void reset() throws GameException {
		// TODO Auto-generated method stub
		
	}
}