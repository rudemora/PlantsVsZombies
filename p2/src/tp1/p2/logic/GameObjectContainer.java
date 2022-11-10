package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;


public class GameObjectContainer {

	private List<GameObject> gameObjects;
	
	protected GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	// TODO add your code here
	protected void addObject(GameObject object) {
		gameObjects.add(object);
	}
	
	protected boolean zombiesGana() {
		for(int i =0;i<gameObjects.size();i=i+1) {
			if (gameObjects.get(i).winner()) { 
				return true;
			}
		}
		return false;
	}
	
	protected boolean isPositionEmpty(int col,int row) {
		for(GameObject g: gameObjects) {
			if(g.isInPosition(col, row)) {
				return false;
			}
		}
		return true;
	}

	
	
	protected GameItem getGameItemInPosition(int col,int row) {  
		for(int i =0;i<gameObjects.size();i=i+1) {
			if ( gameObjects.get(i).isInPosition(col, row)) { 
				return gameObjects.get(i);
			}
		}
		return null;
	}
	
	protected void removeDead() {
		for(int i =0;i<this.gameObjects.size();i=i+1) {
			if (!gameObjects.get(i).isAlive()) {
				gameObjects.remove(i);   
			}
		}
	}
	
	protected void update(boolean add) {
		if (add) {
			for(int i=0; i< this.gameObjects.size() - 1;i++) {
				if (gameObjects.get(i).isAlive()) {
					gameObjects.get(i).update();
				}
			}
		}
		else {
			for(int i=0; i< this.gameObjects.size();i++) {
				if (gameObjects.get(i).isAlive()) {
					gameObjects.get(i).update();
				}
			}
		}
		
	}	
}
