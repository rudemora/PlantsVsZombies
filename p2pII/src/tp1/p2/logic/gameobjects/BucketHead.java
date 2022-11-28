package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class BucketHead extends Zombie {
	
	protected BucketHead (){
		endurance = 8;
	}
	
	protected BucketHead (GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = 8;
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
		return String.format(Messages.BUCKET_HEAD_ZOMBIE_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION.formatted(Messages.BUCKET_HEAD_ZOMBIE_NAME,getSpeed(),getDamage(),getEndurance());
	}

	@Override
	public void update() {
		
		this.addCycle();
		if(!this.game.isFullyOcuppied(col-1, row) && this.canAvanzar()) {
			this.avanzar();
		}
		GameItem item = game.getGameItemInPosition(col - 1, row);
		if(item != null) { // && game.isFullyOcuppied(col-1, row)) {  
			item.receiveZombieAttack(this.getDamage());
		}
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
		return true;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getEndurance() {
		// TODO Auto-generated method stub
		return endurance;
	}

	@Override
	protected int getDamage() {
		// TODO Auto-generated method stub
		return 1;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return Messages.BUCKET_HEAD_ZOMBIE_NAME;
	}
	
	public BucketHead create(GameWorld game, int col, int row) {
		BucketHead buckethead = new BucketHead(game, col, row);
		return buckethead;
	}
	@Override
	protected void avanzar() {
		this.col--;
		
	}

	

}
