package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
public abstract class Zombie extends GameObject {
	protected Zombie() {
		
	}
	
	public Zombie(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	abstract public int getSpeed();
	abstract public Zombie create(GameWorld game, int col, int row);
	
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	
	abstract protected void avanzar();
	
	protected boolean canAvanzar() {
		boolean advance = (this.ciclo % this.getSpeed()) == 0 && this.ciclo != 0;
		if (advance) {
			this.ciclo = 0;
			if (this.col <= -1) {
				game.zombiesGana();
			}
		}
		return advance;
	}
	
	public boolean receivePlantAttack(int damage) {
		this.endurance= this.endurance - damage;
		return true;
	}
	
}
