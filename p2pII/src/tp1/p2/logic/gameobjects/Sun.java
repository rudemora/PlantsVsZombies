package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;



public class Sun extends GameObject {

	// Remember that a Sun is updated the very same cycle is added to the container
	private static final int SUN_COOLDOWN = 10+1;
	private static final int DAMAGE = 0;
	private static final int COINS = 10;
	
	public Sun() {
		endurance = SUN_COOLDOWN;
	}
	
	private Sun(GameWorld game, int col, int row) {
		this.game=game;
		this.col=col;
		this.row=row;
		endurance = SUN_COOLDOWN;
	}
	@Override
	public boolean catchObject() {
		if (endurance > 0) {
			endurance = 0;
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
		return Messages.SUN_SYMBOL;
	}
	
	@Override
	public String getDescription() {
		return Messages.SUN_DESCRIPTION;
	}
	
	@Override
	public void update() {
		endurance--;
	}
	
	@Override
	public void onEnter() {
		game.addGeneratedSuns();
	}
	
	@Override
	public void onExit() {
		game.addCaughtSuns();
		game.addSuncoins(COINS);
	}
	
	@Override
	public int getEndurance() {
		return endurance;
	}
	
	@Override
	protected int getDamage() {
		return DAMAGE;
	}
	
	@Override
	public String getName() {
		return null;
	}

	public Sun create(GameWorld game, int col, int row) {
		Sun sun = new Sun(game, col, row);
		return sun;
	}

}