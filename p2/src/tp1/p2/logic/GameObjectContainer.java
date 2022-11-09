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
	public void addObject(GameObject object) {
		gameObjects.add(object);
	}
	
	public boolean isPositionEmpty(int col,int row) {
		//System.out.print(col);
		for(GameObject g: gameObjects) {
			if(g.isInPosition(col, row)) {
				return false;
			}
	}
		/*for(int i=0; i< this.gameObjects.size();i++) {
			System.out.print(gameObjects.size());
			if (this.gameObjects.get(i).isInPosition(col,row)) {
	    		//System.out.print("A");
				return false;
			}
		}*/
		return true;
	}
	public int getEndurance(int col, int row) {
		for(int i=0; i< this.gameObjects.size();i++) {
			if (this.gameObjects.get(i).isInPosition(col,row)) {
				return this.gameObjects.get(i).getEndurance();
			}
		}
		return -1;
	}
	
	public String getSymbol(int col, int row) {
		for(int i=0; i< this.gameObjects.size();i++) {
			if (this.gameObjects.get(i).isInPosition(col,row)) {
				return this.gameObjects.get(i).getSymbol();
			}
		}
		return "";
	}
}
