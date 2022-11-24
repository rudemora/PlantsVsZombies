package tp1.p2.logic.gameobjects;

import static tp1.p2.view.Messages.status;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;

/**
 * Base class for game non playable character in the game.
 *
 */
public abstract class GameObject implements GameItem {

	protected GameWorld game;

	protected int col;

	protected int row;


	
	protected int endurance;
	protected int ciclo;
	
	
	protected GameObject() {
		
	}

	protected GameObject(GameWorld game, int col, int row) {
		this.game = game;
		this.col = col;
		this.row = row;
		this.ciclo = 0;
	}

	public boolean isInPosition(int col, int row) {
		return this.col == col && this.row == row;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
	public abstract boolean isAlive();

	public String toString() {
		if (isAlive()) {
			// TODO add your code here
		return "aaa";
		} else {
			return "";
		}
	}

	abstract protected String getSymbol();

	abstract public String getDescription();
	
	//abstract public String getName();
	//abstract public int getCost();
	
	abstract public int getEndurance();
	
	abstract protected int getDamage();
	
	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
}