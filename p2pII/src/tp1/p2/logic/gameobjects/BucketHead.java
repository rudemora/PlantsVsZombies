package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;
import java.util.List;

public class BucketHead extends Zombie {
	
	private static final int INITIAL_ENDURANCE = 8;
	private static final int SPEED = 4;
	private static final int DAMAGE = 1;
	
	protected BucketHead (){
		endurance = INITIAL_ENDURANCE;
	}
	
	private BucketHead (GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = INITIAL_ENDURANCE;
	}
	

	@Override
	public boolean catchObject() {
		return false;
	}

	@Override
	protected String getSymbol() {
		return String.format(Messages.BUCKET_HEAD_ZOMBIE_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION.formatted(getName(),getSpeed(),getDamage(),INITIAL_ENDURANCE);
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
		return Messages.BUCKET_HEAD_ZOMBIE_NAME;
	}
	
	@Override
	public BucketHead create(GameWorld game, int col, int row) {
		BucketHead buckethead = new BucketHead(game, col, row);
		return buckethead;
		
	}
	@Override
	protected void avanzar() {
		this.col--;
	}

	

}
