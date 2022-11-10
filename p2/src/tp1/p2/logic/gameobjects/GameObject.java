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

	protected int damage;
	protected int endurance;
	protected int ciclo;
	protected int cost;
	
	protected GameObject() {
		
	}

	protected GameObject(GameWorld game, int col, int row) {
		this.game = game;
		this.col = col;
		this.row = row;
		this.ciclo = 0;
	}

	public boolean isInPosition(int columna, int fila) {
		return this.col == columna && this.row == fila;
	}

	protected int getCol() {
		return col;
	}

	protected int getRow() {
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
	
	abstract public String getName();
	abstract public String getSymbol();
	
	public boolean canAdd() {
		if(game.isPositionEmpty(this.col, this.row) ) {
			return true;
		}
		return false;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	protected void addCycle() {
		this.ciclo = this.ciclo +1;
	}
	
	public boolean winner() {
		if (this.col <= -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
}