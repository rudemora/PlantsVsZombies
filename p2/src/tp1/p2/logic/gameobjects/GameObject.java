package tp1.p2.logic.gameobjects;

import static tp1.p2.view.Messages.status;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;

/**
 * Base class for game non playable character in the game.
 *
 */
public abstract class GameObject implements GameItem {

	public GameWorld game;

	public int col;

	public int row;


	public GameObject() {
		
	}

	public GameObject(GameWorld game, int col, int row) {
		this.game = game;
		this.col = col;
		this.row = row;
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
	
	abstract protected boolean isAlive();

	public String toString() {
		if (isAlive()) {
			return "ee";
			// TODO add your code here
		} else {
			return "";
		}
	}
	
	abstract public int getCost();
	abstract public String getSymbol();
	
	public boolean canAdd(GameWorld game) {
		if(game.isPositionEmpty(col, row)) {
			return true;
		}
		System.out.println(row);

		return false;
	}
	abstract public int getEndurance();

	abstract public String getDescription();

	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
}