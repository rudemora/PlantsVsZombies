package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {
	
	private static final int INITIAL_ENDURANCE = 1;
	private static final int DAMAGE = 0;
	private static final int COST = 20;
	
	protected Sunflower() {
		endurance = INITIAL_ENDURANCE;
		ciclo = 0;
	}
	
	private Sunflower(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = INITIAL_ENDURANCE;
		ciclo = 0;
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
	public String getSymbol() {
		return String.format(Messages.SUNFLOWER_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.SUNFLOWER_NAME_SHORTCUT,getCost(),getDamage(),getEndurance());
	}

	@Override
	public void update() {
		this.addCycle();
		if (addSoles()) {
			game.addSun();
		}		
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
	
	@Override
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}
	
	@Override
	public Sunflower create(GameWorld game, int col, int row) {
		Sunflower sunflower = new Sunflower(game, col, row);
		return sunflower;
	 }
	
	
	private boolean addSoles() {
		if (this.ciclo%4==0) {
			this.ciclo = 1;
			return true;
		}
		return false;
	}


}
