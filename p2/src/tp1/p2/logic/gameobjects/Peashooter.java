package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
public class Peashooter extends Plant {

	
	
	public String getSymbol() {
		return "hola";
	}
	public String getName() {
		return Messages.PEASHOOTER_NAME;
	}
	protected String getShortcut() {
		return Messages.PEASHOOTER_NAME_SHORTCUT;
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
}

