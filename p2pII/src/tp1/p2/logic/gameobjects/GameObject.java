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
	
	public boolean isAlive() {
		if (this.endurance <= 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public String toString() {
		System.out.println(this.getDescription());
		if (isAlive()) {
		
			int endurance = this.endurance;
			String icon= this.getSymbol();
			return status(icon,endurance);
			// TODO add your code here
		} 
		else {
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
	
	abstract public String getName();
	public boolean canAdd() {
		if(game.isPositionEmpty(this.col, this.row) ) {
			return true;
		}
		return false;
	}
	
	public int getCost() {
		return this.getCost();
	}
	
	protected void addCycle() {
		this.ciclo = this.ciclo +1;
	}
}