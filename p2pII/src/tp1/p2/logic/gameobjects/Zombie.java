package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
public abstract class Zombie extends GameObject {
	
	protected Zombie() {
		
	}
	protected Zombie(GameWorld game, int col, int row) {
		super(game, Game.NUM_COLS, row);
	}
	
	abstract public int getSpeed();
	abstract public Zombie create(GameWorld game, int row);
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	abstract protected void avanzar();
	protected boolean canAvanzar() {
		return (this.ciclo % this.getSpeed()) == 0;
	}
	public boolean receivePlantAttack(int damage) {
		this.endurance= this.endurance - damage;
		if (endurance <= 0) {
			game.matarZombie();
		}
		return true;
	}
	
	@Override
	public int getCost() {
		return 0;
	}
}
