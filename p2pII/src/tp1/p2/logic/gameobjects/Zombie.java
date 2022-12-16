package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
public abstract class Zombie extends GameObject {
	protected boolean muertoPorExplosion;
	
	protected Zombie() {
		
	}
	
	public Zombie(GameWorld game, int col, int row) {
		super(game, col, row);
		muertoPorExplosion=false;
	}
	
	abstract public int getSpeed();
	abstract public Zombie create(GameWorld game, int col, int row);
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	
	abstract protected void avanzar();
	
	
	protected boolean canAvanzar() {
		boolean advance = (this.ciclo % this.getSpeed()) == 0 && this.ciclo != 0;
		if (advance) {
			this.ciclo = 0;
		}
		return advance;
	}
	
	@Override
	public boolean receivePlantAttack(int damage, boolean explosion) {
		this.endurance= this.endurance - damage;
		muertoPorExplosion=explosion;
		return true;
	}
	
}
