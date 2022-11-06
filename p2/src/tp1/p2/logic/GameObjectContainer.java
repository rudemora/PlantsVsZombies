package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;

public class GameObjectContainer {

	private List<GameObject> gameObjects;
	private int contador = 0;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	// TODO add your code here
	protected int getContador() {
		return this.contador;
	}
}
