package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
public class Sunflower extends Plant  {//extends Plant tambi�n no?
	
	public Sunflower() {
		super();
	}
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}
	protected String getShortcut() {
		return Messages.SUNFLOWER_NAME_SHORTCUT;
	}
	protected int getCost() {
		return 1;
	}
	protected int getDamage() {
		return 1;
	}
	protected int getEndurance() {
		return 1;
	}
	public String getSymbol() {
		return "hola";
	}
}
