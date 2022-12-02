package tp1.p2.logic;


import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.control.Level;
import java.util.List;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	void pushAction(GameAction gameAction);
	boolean consumeCoins(GameObject object, int coste);
	void addSun();
	void addGameItem(GameObject object);
	boolean tryToCatchObject(int col, int row);
	int getCaughtSuns();
	boolean addItem(GameObject gameObject);
	List<GameItem> getGameItemInPosition(int x, int y);
	void addSuncoins(int Coins);
	void playerQuits();
	boolean isPositionEmpty(int x, int y);
	void update();
	boolean isFullyOcuppied(int col, int row);
	void reset(long seed, Level level);
	Level getLevel();
	long getSeed();
	void explode (int col, int row, int damage, boolean affectsZombies);
	void addZombiesAlived();
	void decreaseZombiesAlived();
	void addCaughtSuns();
	boolean zombiesGana();
	
}




