package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Sun;
import tp1.p2.view.Messages;

public class Game implements GameStatus, GameWorld {

	private static final int INITIAL_SUNCOINS = 50; // HACER LO MISMO CON ENDURANCE (PONER UNA INICIAL) Y CON VIDA(LA QUE CAMBIE)
	private static final int INITIAL_CYCLE = 0;
	private long seed;

	private Level level;
	
	private int cycle;

	private GameObjectContainer container;

	private Deque<GameAction> actions;

	private static boolean playerQuits;
	
	private Random rand;
	
	private ZombiesManager Zombies;
	
	private int sunCoins;
	
	public Game(long seed, Level level) {
		this.reset(level, seed);
	}

	
	/**
	 * Resets the game with the provided level and seed.
	 * 
	 * @param level {@link Level} Used to initialize the game.
	 * @param seed Random seed Used to initialize the game.
	 */
	//@Override
	public void reset(Level level, long seed) {
		// TODO add your code here
		this.seed = seed;
		this.level = level;
		this.container = new GameObjectContainer(); // PREGUNTAR POR QUÉ NO TIENE QUE ESTAR AQUÍ Y ESTABA EN EL CONSTRUCTOR DE GAME
		cycle = INITIAL_CYCLE;
		playerQuits = false;
		this.actions = new ArrayDeque<>();
		this.rand = new Random(this.seed);
		this.Zombies= new ZombiesManager(this,level,rand);
		sunCoins = INITIAL_SUNCOINS;
		System.out.println(String.format(Messages.CONFIGURED_LEVEL, level.name()));
		System.out.println(String.format(Messages.CONFIGURED_SEED, seed));
	}

	
	
	
	
	
	/**
	 * Executes the game actions and update the game objects in the board.
	 * 
	 */
	//@Override
	public void update() {

		// 1. Execute pending actions
		executePendingActions();

		// 2. Execute game Actions
		// TODO add your code here

		// 3. Game object updates
		// TODO add your code here

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
	
	public boolean execute (Command command) {
    	return command.execute(this).draw();
    }

	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPlayerQuits() {
		// TODO Auto-generated method stub
		return playerQuits;
	}

	@Override
	public void addSun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryToCatchObject(int col, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addItem(GameObject gameObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addItem(Sun sun) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCycle() {
		// TODO Auto-generated method stub
		return cycle;
	}

	@Override
	public int getSuncoins() {
		// TODO Auto-generated method stub
		return sunCoins;
	}

	@Override
	public int getRemainingZombies() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String positionToString(int col, int row) {
		String escribe= "";
		if(!container.isPositionEmpty(col, row)) {
			GameItem item = this.getGameItemInPosition(col, row);
			return item.toString();
			
		}
		
		return escribe;
	}
	
	public GameItem getGameItemInPosition(int col, int row) {
    	return container.getGameItemInPosition(col, row);
    }
	
	@Override
	public int getGeneratedSuns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCaughtSuns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void playerQuits() {
		playerQuits = true;
		
	}

	// TODO add your code here

}