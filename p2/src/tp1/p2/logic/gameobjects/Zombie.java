package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
public abstract class Zombie extends GameObject {
	
	public int speed;
	

	abstract public Zombie create(GameWorld game, int row);
	
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	
	public boolean receivePeashooterAttack(int damage) {
		this.endurance= this.endurance - damage;
		if (endurance <= 0) {
			game.matarZombie();
		}
		return true;
	}
	
	abstract protected void avanzar();
	

	
	
	public boolean canAvanzar() {
		return (this.ciclo % this.speed) == 0;
	}
}
