package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
public class Sunflower extends Plant  {//extends Plant tambi�n no?
	
	public Sunflower() {
			
		}
	public Sunflower(GameWorld game, int x, int y) {
		super(game, x, y);
		cost= 50;
		damage= 1;
		endurance = 3;
	}
	
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.SUNFLOWER_NAME_SHORTCUT,cost,damage,endurance);
	}
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}
	protected String getShortcut() {
		return Messages.SUNFLOWER_NAME_SHORTCUT;
	}
	
	public int getCost() {
		return this.cost;
	}
	


	protected int getDamage() {
		return 1;
	}
	protected int getEndurance() {
		return 1;
	}
	
	@Override
	public String getSymbol() {
		return String.format(Messages.SUNFLOWER_SYMBOL, this.endurance);
	}
	
	public Sunflower create(int col, int row) {
		 return new Sunflower(game, col, row);
	 }
	@Override
	protected boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}
}
