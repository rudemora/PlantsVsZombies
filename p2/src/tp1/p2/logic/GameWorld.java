package tp1.p2.logic;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.control.actions.GameAction;  //Único sitio donde se llama GameAction
import tp1.p2.logic.gameobjects.GameObject;


public interface GameWorld {  	

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;
	
	
	

	// TODO add your code here
	public void playerQuits();
	
	abstract public ExecutionResult update();
	abstract public boolean addObject(GameObject object);
	abstract public boolean isPositionEmpty(int x, int y);
	abstract public GameItem getGameItemInPosition(int x, int y);
	abstract public int getSuncoins();
	abstract public void setSuncoins(int coins);
	abstract public void reset(long seed, Level level);
	abstract public void matarZombie();
}