package tp1.p2.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class GameObjectContainer {

	private List<GameObject> gameObjects;

	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}

	public String positionToString(int col, int row) {
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

	public boolean removeDead() {
		// TODO add your code here
		return false;
	}

	public void update() {
		// Can't use for-each loop (for(GameObject g : gameObjexts)) without errors.
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			if(g.isAlive()) {
				g.update();
			}
		}
	}

	public boolean isFullyOccupied(int col, int row) {
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
			if ( gameObjects.get(i).isInPosition(col, row)) { 
				return gameObjects.get(i);
			}
		}
		return null;
	}
	// TODO add your code here

}