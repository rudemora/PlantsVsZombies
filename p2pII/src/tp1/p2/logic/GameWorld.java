package tp1.p2.logic;


import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Sun;
import tp1.p2.control.Level;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	// TODO add your code here
	abstract void pushAction(int col, int row, int damage, boolean affectsZombies);
	abstract void addSun();
	abstract void addGameItem(GameObject object);
	boolean tryToCatchObject(int col, int row);
	abstract int getCaughtSuns();
	abstract boolean addItem(GameObject gameObject, boolean consumeCoins);
	abstract GameItem getGameItemInPosition(int x, int y);
	abstract void addSuncoins(int Coins);
	abstract void playerQuits();
	abstract boolean isPositionEmpty(int x, int y);
	abstract void update();
	abstract void matarZombie();//Pensar si todos estos metodos tienen que ser abstractos
	abstract boolean isFullyOcuppied(int col, int row);
	abstract void reset(long seed, Level level);
	abstract Level getLevel();
	abstract long getSeed();
	abstract void explode (int col, int row, int damage, boolean affectsZombies);
}




