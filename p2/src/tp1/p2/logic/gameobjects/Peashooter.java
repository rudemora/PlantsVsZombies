package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
 

public class Peashooter extends Plant {
	
	private GameWorld game;
	
	public Peashooter (){
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
	protected int getDamage() {
		return 1;
	}
	
	
	

	 
	 @Override
	 public String getSymbol() {
			return String.format(Messages.PEASHOOTER_SYMBOL, this.endurance);
	}
	 @Override
	 public int getEndurance() {
		 return this.endurance;
	 }
	public void create(GameWorld game, int col, int row) {
		this.game = game;
		this.col=col;
		this.row=row;
		
	 }

	@Override
	protected boolean isAlive() {
		if (this.endurance > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onEnter() {
		
	}
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}
}

