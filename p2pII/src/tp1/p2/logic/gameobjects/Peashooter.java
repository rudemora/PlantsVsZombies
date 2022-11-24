package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	
	protected Peashooter (){
		endurance = 3;
	}
	
	protected Peashooter(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = 3;
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
		return String.format(Messages.PEASHOOTER_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.PEASHOOTER_NAME_SHORTCUT,getCost(),getDamage(),getEndurance());
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
	public int getCost() {
		return 50;
	}
	
	@Override
	public int getEndurance() {
		return endurance;
	}
	
	@Override
	public int getDamage() {
		return 1;
	}
	
	@Override
	public boolean fillPosition() {
		// TODO Auto-generated method stub
		return false;
	}

}
