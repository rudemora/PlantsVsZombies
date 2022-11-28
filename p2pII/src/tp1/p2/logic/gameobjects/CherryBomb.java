package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class CherryBomb extends Plant {
	
	public static final int INITIAL_ENDURANCE = 2;

	protected CherryBomb() {
		endurance = INITIAL_ENDURANCE;
		ciclo = 2;
	}
	
	protected CherryBomb(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance =  INITIAL_ENDURANCE;
		ciclo = 2;
	}
	
	@Override
	public int getCost() {
		return 50;
	}
	
	
	@Override
	public int getEndurance() {
		return INITIAL_ENDURANCE;
	}
	
	@Override 
	public int getDamage() {
		return 10;
	}
	
	/*@Override
	public boolean receiveZombieAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public boolean catchObject() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		if (ciclo > 0) {
			ciclo--;
		}
		else if (ciclo == 0) {
			game.pushAction(col, row, getDamage());
			endurance = 0;
		}
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		//game.pushAction(col, row, getDamage());
	}

	@Override
	public boolean fillPosition() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return Messages.CHERRY_BOMB_NAME;
	}
	public CherryBomb create(GameWorld game, int col, int row) {
		CherryBomb cherrybomb = new CherryBomb(game, col, row);
		return cherrybomb;
	 }

	

}
