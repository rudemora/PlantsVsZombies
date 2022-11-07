package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;

public class GameObjectContainer {

	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	// TODO add your code here
	public void add(GameObject object) {
		gameObjects.add(object);
	}
	
	public boolean isPositionEmpty(int col,int row) {
		for(int i=0; i< this.gameObjects.size();i++) {
			if (this.gameObjects.get(i).hay_algo(col,row)) {
				return false;
			}
		}
		return true;
	}
	public int endurance(int col, int row) {
		for(int i=0; i< this.gameObjects.size();i++) {
			if (this.gameObjects.get(i).hay_algo(col,row)) {
				return this.gameObjects.get(i).getEndurance();
			}
		}
		return -1;
	}
	
	public String getsymbol(int col, int row) {
		for(int i=0; i< this.gameObjects.size();i++) {
			if (this.gameObjects.get(i).hay_algo(col,row)) {
				return this.gameObjects.get(i).getSymbol();
			}
		}
		return "";
	}
}
