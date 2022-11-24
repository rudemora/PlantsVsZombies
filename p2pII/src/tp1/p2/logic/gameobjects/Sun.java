package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;



public class Sun extends GameObject {
	private GameWorld game;
	private int col;
	private int row;
	// Remember that a Sun is updated the very same cycle is added to the container
	public static final int SUN_COOLDOWN = 10+1;
	public Sun(GameWorld game, int col, int row) {
		this.game=game;
		this.col=col;
		this.row=row;
	}
	@Override
	public boolean catchObject() {
		// TODO add your code here
		return true;
	}

	@Override
	public boolean fillPosition() {
		return false;
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
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected String getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
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
	public int getEndurance() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
}