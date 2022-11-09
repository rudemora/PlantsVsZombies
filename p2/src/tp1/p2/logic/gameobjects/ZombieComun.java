package tp1.p2.logic.gameobjects;

import tp1.p2.logic.Game;
import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;
public class ZombieComun extends Zombie {
	

	
	public ZombieComun() {
		speed= 2;
		damage= 1;
		endurance = 5;
		col = Game.NUM_COLS;
		cost = 0;
	}
	
	@Override
	public String getName() {
		return Messages.ZOMBIE_NAME;
	}
	
	@Override
	public String getSymbol() {{
		return Messages.ZOMBIE_SYMBOL;
	}
}


	@Override
	public void update() {
		this.addCycle();
		GameItem item = game.getGameItemInPosition(col - 1, row);
		if(item != null ) {  
    		item.receiveZombieAttack(this.damage);
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
	
	public ZombieComun create(GameWorld game, int row) {
		ZombieComun Z = new ZombieComun();
		Z.game = game;
		Z.row=row;
		return Z;
	}

	protected void avanzar() {
		this.col--;
	}
	
	
}
