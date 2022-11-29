package tp1.p2.logic.actions;

import tp1.p2.logic.GameWorld;

public class ExplosionAction implements GameAction {

	private int col;

	private int row;

	private int damage;

	private boolean affectsZombies;
	
	public ExplosionAction(int col, int row, int damage, boolean affectsZombies) {
		this.col = col;
		this.row = row;
		this.damage = damage;
		this.affectsZombies = affectsZombies;
	}

	@Override
	public void execute(GameWorld game) {
		game.explode(col, row, damage, affectsZombies);
	}

	
}
