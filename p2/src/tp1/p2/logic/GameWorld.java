package tp1.p2.logic;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.control.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;


import tp1.p2.logic.gameobjects.Plant; //añadido para que funcione el add

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;
	
	//void playerQuits();
	//ExecutionResult update();
	// TODO add your code here
	public void playerQuits();
	
	
	abstract public void addGameObject(GameObject object);
	

	
}