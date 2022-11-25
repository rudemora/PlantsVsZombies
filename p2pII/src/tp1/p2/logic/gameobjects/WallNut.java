package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class WallNut extends Plant {

	protected WallNut (){
		endurance = 10;
	}
	
	protected WallNut(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = 10;
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
		return 0;
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
		return String.format(Messages.WALL_NUT_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.WALL_NUT_NAME_SHORTCUT,getCost(),getDamage(),getEndurance());
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
	
	public String getName() {
		// TODO Auto-generated method stub
		return Messages.WALL_NUT_NAME;
	}
	
	public WallNut create(GameWorld game, int col, int row) {
		WallNut wallnut = new WallNut(game, col, row);
		return wallnut;
	 }

}
