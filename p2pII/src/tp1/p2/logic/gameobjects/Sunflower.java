package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {

	private int soles;
	
	protected Sunflower() {
		soles = 10;
		endurance = 1;
	}
	
	protected Sunflower(GameWorld game, int col, int row) {
		super(game, col, row);
		soles = 10;
		endurance = 1;
	}
	
	@Override
	public int getCost() {
		return 20;
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
			this.game.addSuncoins(this.addSoles());
		
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
		return Messages.SUNFLOWER_NAME;
	}
	public Sunflower create(GameWorld game, int col, int row) {
		Sunflower sunflower = new Sunflower(game, col, row);
		return sunflower;
	 }
	private int addSoles() {
		if (this.ciclo%4==0) {
			this.ciclo = 1;
			return soles;
		}
		return 0;
	}

}
