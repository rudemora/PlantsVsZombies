package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
public abstract class Zombie extends GameObject {
	
	protected Zombie() {
		
	}
	protected Zombie(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	abstract public int getSpeed();
}
