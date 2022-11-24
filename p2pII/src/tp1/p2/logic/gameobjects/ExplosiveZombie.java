package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ExplosiveZombie extends Zombie {

	protected ExplosiveZombie (){
		endurance = 5;
	}
	
	protected ExplosiveZombie (GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = 5;
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean catchObject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getSymbol() {
		return String.format(Messages.EXPLOSIVE_ZOMBIE_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION.formatted(Messages.EXPLOSIVE_ZOMBIE_NAME,getSpeed(),getDamage(),getEndurance());
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean fillPosition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getEndurance() {
		// TODO Auto-generated method stub
		return endurance;
	}

	@Override
	protected int getDamage() {
		// TODO Auto-generated method stub
		return 1;
	}

}
