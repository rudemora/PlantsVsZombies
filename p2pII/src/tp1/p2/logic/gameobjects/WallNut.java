package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class WallNut extends Plant {
	
	private static final int INITIAL_ENDURANCE = 10;
	private static final int DAMAGE = 0;
	private static final int COST = 50;
	
	protected WallNut (){
		endurance = INITIAL_ENDURANCE;
	}
	
	private WallNut(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = INITIAL_ENDURANCE;
	}
	
	@Override
	public int getCost() {
		return COST;
	}
	
	@Override
	public int getEndurance() {
		return endurance;
	}
	
	@Override 
	public int getDamage() {
		return DAMAGE;
	}
	
	@Override
	public boolean catchObject() {
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
		
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onExit() {
		
	}

	@Override
	public boolean fillPosition() {
		return true;
	}
	
	public String getName() {
		return Messages.WALL_NUT_NAME;
	}
	
	public WallNut create(GameWorld game, int col, int row) {
		WallNut wallnut = new WallNut(game, col, row);
		return wallnut;
	 }


}
