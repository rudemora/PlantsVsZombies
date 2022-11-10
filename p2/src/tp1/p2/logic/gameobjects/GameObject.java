package tp1.p2.logic.gameobjects;

import static tp1.p2.view.Messages.status;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

/**
 * Base class for game non playable character in the game.
 *
 */
public abstract class GameObject implements GameItem {

	protected GameWorld game;

	public int col;

	public int row;

	public int damage;
	public int endurance;
	public int ciclo;
	public int cost;
	
	public GameObject() {
		
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
	


	public int getDamage() {
		return this.damage;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void addCycle() {
		this.ciclo = this.ciclo +1;
	}
	
	public int getEndurance() {
		return this.endurance;
	}
	
	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
}