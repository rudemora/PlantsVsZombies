package tp1.p2.logic.gameobjects;

import java.util.List;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sporty extends Zombie {
	
	private static final int INITIAL_ENDURANCE = 2;
	private static final int DAMAGE = 1;
	private static final int SPEED = 1;
	
	protected Sporty (){
		endurance = INITIAL_ENDURANCE;
	}
	
	private Sporty (GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = INITIAL_ENDURANCE;
	}
	
	@Override
	public boolean catchObject() {
		return false;
	}

	@Override
	protected String getSymbol() {
		return String.format(Messages.SPORTY_ZOMBIE_SYMBOL, this.getEndurance());
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
		List<GameItem> lista = game.getGameItemInPosition(col - 1, row);
		if(lista != null) { 
			for(int i =0;i<lista.size();i=i+1) {
				lista.get(i).receiveZombieAttack(this.getDamage());
			}
		}
		if (this.col <= -1) {
			game.zombiesGana();
		}
		
	}

	@Override
	public void onEnter() {
		game.addZombiesAlived();
	}

	@Override
	public void onExit() {
		game.decreaseZombiesAlived();
		if(!muertoporexplosion) {
			game.addPuntos(10);
		}
		else {
			game.addPuntos(20);
		}
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
	public String getName() {
		return Messages.SPORTY_ZOMBIE_NAME;
	}

	@Override
	public Sporty create(GameWorld game, int col, int row) {
		Sporty sporty = new Sporty(game, col, row);
		return sporty;
	}
	
	@Override
	protected void avanzar() {
		this.col--;
	}

}
