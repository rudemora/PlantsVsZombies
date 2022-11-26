package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ZombieComun extends Zombie {
	
	protected ZombieComun (){
		endurance = 5;
	}
	
	protected ZombieComun (GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = 5;
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
		return String.format(Messages.ZOMBIE_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.ZOMBIE_DESCRIPTION.formatted(Messages.ZOMBIE_NAME,getSpeed(),getDamage(),getEndurance());
	}

	@Override
	public void update() {
		this.addCycle();
		GameItem item = game.getGameItemInPosition(col - 1, row);
		if(item != null ) {  
    		item.receiveZombieAttack(this.getDamage());
		}
		else {
			if(this.game.isPositionEmpty(col-1, row) && this.canAvanzar()) {
				this.avanzar();
			}
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
		return false;
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

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ZombieComun create(GameWorld game, int col, int row) {
		ZombieComun zombieComun = new ZombieComun(game, col, row);
		return zombieComun;
	}

	@Override
	protected void avanzar() {
		this.col--;
		
	}


}
