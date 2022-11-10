package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.Game;
import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;

 

public class Peashooter extends Plant {
	
	protected Peashooter (){
		cost= 50;
		damage= 1;
		endurance = 3;
	}
	
	protected Peashooter(GameWorld game, int col, int row) {
		super(game, col, row);
		cost= 50;
		damage= 1;
		endurance = 3;
	}
	
	
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.PEASHOOTER_NAME_SHORTCUT,cost,damage,endurance);
	 }
	
	public String getName() {
		return Messages.PEASHOOTER_NAME;
	}
	
	protected String getShortcut() {
		return Messages.PEASHOOTER_NAME_SHORTCUT;
	}
	
	public int getCost() {
		return this.cost;
	}

	@Override
	public String getSymbol() {
			return String.format(Messages.PEASHOOTER_SYMBOL, this.endurance);
	}

	public Peashooter create(GameWorld game, int col, int row) {
		Peashooter peashooter = new Peashooter(game, col, row);
		return peashooter;
	 }
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.addCycle();
		int i = col + 1;
		boolean atacked = false;
		while (!atacked && i <Game.NUM_COLS) {
			GameItem item = game.getGameItemInPosition(i, row);
			if(item != null ) {  
    		atacked = item.receivePeashooterAttack(this.damage);
			}
			i = i +1;
		}
		
	}
	@Override
	public void onEnter() {
		
	}
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}
}

