package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
public class Peashooter extends Plant {
	private int cost=50;
	private int damage=20;
	private int endurance=3;
	private int posx;
	private int posy;
	private GameWorld game;
	
	 public String getDescription() {
		 return Messages.PLANT_DESCRIPTION.formatted(Messages.PEASHOOTER_NAME_SHORTCUT,this.cost,this.damage,this.endurance);
	 }
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

