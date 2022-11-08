package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.PlantFactory;
//Las subclases y superclases tienen que importarse mutuamente?




public abstract class Plant extends GameObject {
	public int cost;
	public int damage;
	public int endurance;
	public GameWorld game;
	
	public Plant() {
		
	}
	
	public Plant(GameWorld game, int col, int row) {
		super(game, col, row);
	}
	
	abstract public String getDescription();
	
	abstract public int getCost();


	public abstract String getName();
	abstract public String getSymbol();
	abstract public Plant create(int col, int row);
}
