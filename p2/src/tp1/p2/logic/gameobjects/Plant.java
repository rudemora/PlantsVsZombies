package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.PlantFactory;
//Las subclases y superclases tienen que importarse mutuamente?




public abstract class Plant extends PlantFactory {
	protected int cost;
	protected int damage;
	protected int endurance;
	protected int posx;
	protected int posy;
	protected GameWorld game;
	
	//public Plant()
	
	abstract public String getDescription();
	
	abstract public int getCost();
	abstract public int getCol();
	abstract public int getRow();

	public abstract String getName();
	abstract public String getSymbol();
	//public abstract void add();
	
}
