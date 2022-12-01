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
	protected int endurance; //quitaría esto de aquí y lo pondría en cada gameObject, en el toString haría un getEndurance();
	protected int ciclo; //quizá haya que quitar esto también
	
	
	public GameObject() {
		
	}

	protected GameObject(GameWorld game, int col, int row) {
		this.game = game;
		this.col = col;
		this.row = row;
		this.ciclo = -1;
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
		if (isAlive()) { // y si hacemos un toString en cada elemento con override y podemos quitar esto
			int endurance = this.endurance;
			String icon= this.getSymbol();
			return status(icon,endurance);
		} 
		else {
			return "";
		}
	}

	abstract protected String getSymbol();

	abstract public String getDescription();
	

	
	abstract public int getEndurance();
	
	abstract protected int getDamage();
	
	abstract public void update();
	
	abstract public void onEnter();
	
	abstract public void onExit();
	
	abstract protected String getName();
	
	protected void addCycle() {
		this.ciclo = this.ciclo +1;
	}
	/*
	public boolean winner() {
		if (this.col <= -1) {
			return true;
		}
		else {
			return false;
		}
	}*/
	
	abstract public boolean fillPosition();
	
	
	
}