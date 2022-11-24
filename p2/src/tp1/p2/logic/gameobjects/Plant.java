package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;




public abstract class Plant extends GameObject {
	
	public Plant() {
		
	}
	
	public Plant(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	abstract int getCost();
	
	
	
}
