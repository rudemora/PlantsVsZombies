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
		int i = 0;
		while (i<this.gameObjects.size()) {
			if (!gameObjects.get(i).isAlive()) {
				gameObjects.get(i).onExit();
				gameObjects.remove(i);   
				ok=true;
			}
			else {
				i++;
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
	
	protected List<GameItem> getGameItemInPosition(int col,int row) {
		List<GameItem> lista= new ArrayList<>();
		for(int i =0;i<gameObjects.size();i=i+1) {
			if (gameObjects.get(i).isInPosition(col, row) && gameObjects.get(i).fillPosition()) { 
				lista.add(gameObjects.get(i));
			}
		}
		if(lista.size()==0) {
			return null;
		}
		return lista;
	}
	
	protected boolean tryToCatchObject(int col, int row) {
		boolean ok=false;
		if (!this.isPositionEmpty(col, row)) {
			for(GameObject g : gameObjects) {
				if(g.isInPosition(col, row) && g.catchObject()) {
					ok=true;
				}
			}
		}
		return ok;
	}
	
	protected void addObject(GameObject object) {
		gameObjects.add(object);
		object.onEnter();
	}
	
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