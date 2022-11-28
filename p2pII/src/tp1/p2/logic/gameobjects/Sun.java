package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;



public class Sun extends GameObject {

	//private int endurance;
	// Remember that a Sun is updated the very same cycle is added to the container
	public static final int SUN_COOLDOWN = 10+1;
	
	public Sun() {
		endurance = SUN_COOLDOWN;
	}
	public Sun(GameWorld game, int col, int row) {
		this.game=game;
		this.col=col;
		this.row=row;
		endurance = SUN_COOLDOWN;
	}
	@Override
	public boolean catchObject() {
		// TODO add your code here
		if (endurance > 0) {
			this.onExit();
			return true;
		}
		return false;
	}

	@Override
	public boolean fillPosition() {
		return false;
	}
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	@Override
	protected String getSymbol() {
		// TODO Auto-generated method stub
		return Messages.SUN_SYMBOL;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return Messages.SUN_DESCRIPTION;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		endurance--;
	}
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		endurance = 0;
	}
	@Override
	public int getEndurance() {
		// TODO Auto-generated method stub
		return endurance;
	}
	@Override
	protected int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sun create(GameWorld game, int col, int row) {
		Sun sun = new Sun(game, col, row);
		return sun;
	}
	
	@Override
	public boolean receiveExplosion(int damage) {
		return false;
	}
}