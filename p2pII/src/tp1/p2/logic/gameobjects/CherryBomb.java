package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {
	
	private static final int INITIAL_ENDURANCE = 2;
	private static final int DAMAGE = 10;
	private static final int COST = 50;

	protected CherryBomb() {
		endurance = INITIAL_ENDURANCE;
		ciclo = 2;
	}
	
	private CherryBomb(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance =  INITIAL_ENDURANCE;
		ciclo = 2;
	}
	
	@Override
	public int getCost() {
		return COST;
	}
	
	
	@Override
	public int getEndurance() {
		return INITIAL_ENDURANCE;
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
		if (ciclo != 0) {
			return String.format(Messages.CHERRY_BOMB_SYMBOL, this.getEndurance());
		}
		else {
			return String.format((Messages.CHERRY_BOMB_SYMBOL).toUpperCase(), this.getEndurance());
		}
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.CHERRY_BOMB_NAME_SHORTCUT,getCost(),getDamage(),getEndurance());
	}

	@Override
	public void update() {
		if (ciclo > 0) {
			ciclo--;
		}
		else if (ciclo == 0) {
			game.pushAction(col, row, getDamage(), true);
			endurance = 0;
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
	
	public String getName() {
		return Messages.CHERRY_BOMB_NAME;
	}
	
	public CherryBomb create(GameWorld game, int col, int row) {
		CherryBomb cherrybomb = new CherryBomb(game, col, row);
		return cherrybomb;
	 }

	

}
