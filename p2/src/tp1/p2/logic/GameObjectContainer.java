package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;

public class GameObjectContainer {

	public List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	// TODO add your code here
	public void addObject(GameObject object) {
		gameObjects.add(object);
	}
	

	
	public boolean zombiesGana() {
		for(int i =0;i<gameObjects.size();i=i+1) {
			if (gameObjects.get(i).col == -1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPositionEmpty(int col,int row) {
		for(GameObject g: gameObjects) {
			if(g.isInPosition(col, row)) {
				return false;
			}
		}
		
		return true;
	}

	
	
	public GameItem getGameItemInPosition(int col,int row) {  
		for(int i =0;i<gameObjects.size();i=i+1) {
			if ( gameObjects.get(i).isInPosition(col, row)) { 
				return gameObjects.get(i);
			}
		}
		return null;
		
	}
	
	public void update() {
		for(int i=0; i< this.gameObjects.size();i++) {
			if (gameObjects.get(i).isAlive()) {
				gameObjects.get(i).update();
			}
			else {
				gameObjects.remove(i);   
			}
		}
	}
}
