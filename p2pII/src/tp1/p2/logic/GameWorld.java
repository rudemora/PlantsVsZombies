package tp1.p2.logic;


import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Sun;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	// TODO add your code here

	void addSun();

	boolean tryToCatchObject(int col, int row);

	abstract boolean addItem(GameObject gameObject, boolean consumeCoins);
	abstract public GameItem getGameItemInPosition(int x, int y);
	abstract public void addSuncoins(int Coins);
	void addItem(Sun sun);
	abstract public void addGameObject(GameObject object);
	abstract void playerQuits();
	abstract public void removeDead();
	abstract public boolean isPositionEmpty(int x, int y);
	abstract public void update();
	abstract public void matarZombie();//Pensar si todos estos metodos tienen que ser abstractos
	abstract boolean isFullyOcuppied(int col, int row);
}