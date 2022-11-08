package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.Peashooter;
import tp1.p2.logic.gameobjects.Sunflower;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;


public  class PlantFactory {
	
	private GameWorld game;
	
	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(),
		new Peashooter()
	);
	/* @formatter:on */

	

	public static Plant spawnPlant(String plantName, GameWorld game, int col, int row) {
		// TODO add your code here
		for(Plant p: PlantFactory.getAvailablePlants()) {
			if(p.getName().equalsIgnoreCase(plantName) || p.getSymbol().equalsIgnoreCase(plantName)) {
				p.create(game, col, row);
				return p;
			}
		}
		System.out.println(Messages.INVALID_GAME_OBJECT);
		return null;
	}

	public static List<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}
	
	
	
	/*
	 * Avoid creating instances of this class
	 */
	
	

}