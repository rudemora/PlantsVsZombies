package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public abstract class Zombie extends GameObject {
	
	public int speed;
	public Zombie() {
	}
	
	public Zombie(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	abstract public Zombie create(GameWorld game, int row);
	
}
