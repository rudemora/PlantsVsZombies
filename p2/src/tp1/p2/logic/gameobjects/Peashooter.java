package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
public class Peashooter extends Plant {
	
	protected Peashooter() {
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
	protected int getEndurance() {
		return 1;
	}
	
	 public int getCol() {
		 return this.posx;
	 }
	 
	 public int getRow() {
		 return this.posy;
	 }
	 
	 @Override
	 public String getSymbol() {
			return String.format(Messages.PEASHOOTER_SYMBOL, this.endurance);
	}
		
}

