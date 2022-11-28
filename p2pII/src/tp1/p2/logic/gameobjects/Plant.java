package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;




public abstract class Plant extends GameObject {
	
	public Plant() {
		
	}
	
	public Plant(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	abstract public int getCost();
	
	abstract public Plant create(GameWorld game, int col, int row);
	
	public boolean receiveZombieAttack(int damage) {
		this.endurance = this.endurance - damage;
		return true;
	}
	
	public boolean receivePlantAttack(int damage) {
		return false;
	}
}
