package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class GameObjectContainer {

	private List<GameObject> gameObjects;

	protected GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	boolean removeDead() {
		
		boolean ok=false;
		for(int i =0;i<this.gameObjects.size();i=i+1) {
			if (!gameObjects.get(i).isAlive()) {
				gameObjects.get(i).onExit();
				gameObjects.remove(i);   
				ok=true;
			}
		}
		return ok;
	}

	protected void update() {
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			if(g.isAlive()) {
				g.update();
			}
		}
	}

	protected boolean isFullyOccupied(int col, int row) {
		int i=0;
		boolean fullyOcuppied = false;
		while (i<gameObjects.size() && !fullyOcuppied) {
			GameObject g = gameObjects.get(i);
			if (g.isAlive() && g.isInPosition(col, row)) {
				fullyOcuppied = g.fillPosition();
			}
			i++;
		}

		return fullyOcuppied;
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
			if (gameObjects.get(i).isInPosition(col, row) && gameObjects.get(i).fillPosition()) { 
				return gameObjects.get(i);
			}
		}
		return null;
	}
	
	protected boolean tryToCatchObject(int col, int row) {
		if (!this.isPositionEmpty(col, row)) {
			for(GameObject g : gameObjects) {
				if(g.isInPosition(col, row) && g.catchObject()) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected void addObject(GameObject object) {
		gameObjects.add(object);
		object.onEnter();
	}
	/*
	protected boolean zombiesGana() {
		for(int i =0;i<gameObjects.size();i=i+1) {
			if (gameObjects.get(i).winner()) { 
				return true;
			}
		}
		return false;
	}*/
	
	protected String positionToString(int col, int row) {
		StringBuilder buffer = new StringBuilder();
		boolean sunPainted = false;
		boolean sunAboutToPaint = false;

		for (GameObject g : gameObjects) {
			if(g.isAlive() && g.getCol() == col && g.getRow() == row) {
				String objectText = g.toString();
				sunAboutToPaint = objectText.indexOf(Messages.SUN_SYMBOL) >= 0;
				if (sunAboutToPaint) {
					if (!sunPainted) {
						buffer.append(objectText);
						sunPainted = true;
					}
				} else {
					buffer.append(objectText);
				}
			}
		}

		return buffer.toString();
	}
	
}