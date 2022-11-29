package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ExplosiveZombie extends Zombie {

	private static final int DAMAGE_EXPLOSION = 3;
	private static final int INITIAL_ENDURANCE = 5;
	private static final int DAMAGE = 1;
	private static final int SPEED = 2;
	
	protected ExplosiveZombie (){
		endurance = INITIAL_ENDURANCE;
	}
	
	private ExplosiveZombie (GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = INITIAL_ENDURANCE;
	}
	
	
	@Override
	public boolean catchObject() {
		return false;
	}



	@Override
	protected String getSymbol() {
		return String.format(Messages.EXPLOSIVE_ZOMBIE_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION.formatted(getName(),getSpeed(),getDamage(),getEndurance());
	}


	@Override
	public void update() {
		this.addCycle();
		if(!this.game.isFullyOcuppied(col-1, row) && this.canAvanzar()) {
			this.avanzar();
		}
		GameItem item = game.getGameItemInPosition(col - 1, row);
		if(item != null) { 
			item.receiveZombieAttack(this.getDamage());
		}
	}

	@Override
	public void onEnter() {
		
	}

	@Override
	public void onExit() {
		game.pushAction(col, row, DAMAGE_EXPLOSION, false);
	}

	@Override
	public boolean fillPosition() {
		return true;
	}

	@Override
	public int getSpeed() {
		return SPEED;
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
	protected String getName() {
		return Messages.EXPLOSIVE_ZOMBIE_NAME;
	}
	
	public ExplosiveZombie create(GameWorld game,int col, int row) {
		ExplosiveZombie explosivezombie = new ExplosiveZombie(game, col, row);
		return explosivezombie;
	}
	
	@Override
	protected void avanzar() {
		this.col--;
	}

	

}
