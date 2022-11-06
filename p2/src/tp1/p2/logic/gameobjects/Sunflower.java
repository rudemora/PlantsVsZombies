package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
public class Sunflower extends Plant  {//extends Plant tambi�n no?
	
	protected Sunflower () {
		cost = 20;
		damage = 0;
		endurance = 1;
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
	
	 public int getCol() {
		 return this.posx;
	 }
	 
	 public int getRow() {
		 return this.posy;
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
	
}
